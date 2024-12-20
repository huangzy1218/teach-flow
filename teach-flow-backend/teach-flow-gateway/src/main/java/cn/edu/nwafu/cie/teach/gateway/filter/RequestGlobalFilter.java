package cn.edu.nwafu.cie.teach.gateway.filter;

import cn.edu.nwafu.cie.teach.common.constant.CommonConstants;
import cn.edu.nwafu.cie.teach.common.constant.SecurityConstants;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.addOriginalRequestUrl;

/**
 * 全局拦截器，作用所有的微服务。
 * <ol>
 *  <li>对请求头中参数进行处理，from 参数进行清洗</li>
 *  <li>重写 StripPrefix=1，支持全局</li>
 * </ol>
 *
 * @author Huang Z.Y.
 * @create 2024-11-25 22:15
 */
public class RequestGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1. 清洗请求头中 from 参数
        ServerHttpRequest request = exchange.getRequest().mutate().headers(httpHeaders -> {
            httpHeaders.remove(SecurityConstants.FROM);
            // 设置请求时间
            httpHeaders.put(CommonConstants.REQUEST_START_TIME,
                    Collections.singletonList(String.valueOf(System.currentTimeMillis())));
        }).build();

        // 2. 重写 StripPrefix，网关转发到业务模块时候会自动截取前缀
        addOriginalRequestUrl(exchange, request.getURI());
        String rawPath = request.getURI().getRawPath();
        String newPath = "/" + Arrays.stream(StringUtils.tokenizeToStringArray(rawPath, "/"))
                .skip(1L)
                .collect(Collectors.joining("/"));

        ServerHttpRequest newRequest = request.mutate().path(newPath).build();
        exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, newRequest.getURI());

        return chain.filter(exchange.mutate().request(newRequest.mutate().build()).build());
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
    