package cn.edu.nwafu.cie.teach.gateway.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.reactor.context.SaReactorSyncHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.edu.nwafu.cie.teach.common.api.R;
import cn.edu.nwafu.cie.teach.common.constant.AuthConstants;
import cn.edu.nwafu.cie.teach.gateway.util.StpMemberUtils;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.server.ServerWebExchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Sa-Token 相关配置。
 *
 * @author Huang Z.Y.
 * @create 2024-12-08 20:05
 */
@Configuration
public class SaTokenConfig {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 注册 Sa-Token 全局过滤器
     */
    @Bean
    public SaReactorFilter getSaReactorFilter(IgnoreUrlsConfig ignoreUrlsConfig) {
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")
                // 配置白名单路径
                .setExcludeList(ignoreUrlsConfig.getUrls())
                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    // 对于OPTIONS预检请求直接放行
                    SaRouter.match(SaHttpMethod.OPTIONS).stop();
                    // 登录认证：商城前台会员认证
                    SaRouter.match("/teach-flow/**", r -> StpMemberUtils.checkLogin()).stop();
                    // 登录认证：管理后台用户认证
                    SaRouter.match("/teach-flow/admin/**", r -> StpUtil.checkLogin());
                    // 权限认证：管理后台用户权限校验
                    // 获取Redis中缓存的各个接口路径所需权限规则
                    Map<Object, Object> pathResourceMap = redisTemplate.opsForHash().entries(AuthConstants.PATH_RESOURCE_MAP);
                    // 获取到访问当前接口所需权限（一个路径对应多个资源时，拥有任意一个资源都可以访问该路径）
                    List<String> needPermissionList = new ArrayList<>();
                    // 获取当前请求路径
                    String requestPath = SaHolder.getRequest().getRequestPath();
                    // 创建路径匹配器
                    PathMatcher pathMatcher = new AntPathMatcher();
                    Set<Map.Entry<Object, Object>> entrySet = pathResourceMap.entrySet();
                    for (Map.Entry<Object, Object> entry : entrySet) {
                        String pattern = (String) entry.getKey();
                        if (pathMatcher.match(pattern, requestPath)) {
                            needPermissionList.add((String) entry.getValue());
                        }
                    }
                    // 接口需要权限时鉴权
                    if (CollUtil.isNotEmpty(needPermissionList)) {
                        SaRouter.match(requestPath, r -> StpUtil.checkPermissionOr(Convert.toStrArray(needPermissionList)));
                    }
                })
                // setAuth方法异常处理
                .setError(this::handleException);
    }

    /**
     * 自定义异常处理
     */
    private R<?> handleException(Throwable e) {
        // 设置错误返回格式为 JSON
        ServerWebExchange exchange = SaReactorSyncHolder.getContext();
        HttpHeaders headers = exchange.getResponse().getHeaders();
        headers.set("Content-Type", "application/json; charset=utf-8");
        headers.set("Access-Control-Allow-Origin", "*");
        headers.set("Cache-Control", "no-cache");
        R<?> result;
        if (e instanceof NotLoginException) {
            result = R.unauthorized(null);
        } else if (e instanceof NotPermissionException) {
            result = R.forbidden(null);
        } else {
            result = R.failed(e.getMessage());
        }
        return result;
    }
}
    