package cn.edu.nwafu.cie.teach.common.constant;

/**
 * 权限相关常量定义。
 *
 * @author Huang Z.Y.
 * @create 2024-12-09 00:24
 */
public interface AuthConstants {
    /**
     * JWT 存储权限前缀
     */
    String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT 存储权限属性
     */
    String AUTHORITY_CLAIM_NAME = "authorities";

    /**
     * 后台管理 client_id
     */
    String ADMIN_CLIENT_ID = "admin-app";

    /**
     * 后台管理接口路径匹配
     */
    String ADMIN_URL_PATTERN = "/mall-admin/**";

    /**
     * Redis缓存权限规则（路径->资源）
     */
    String PATH_RESOURCE_MAP = "auth:pathResourceMap";

    /**
     * 认证信息Http请求头
     */
    String JWT_TOKEN_HEADER = "Authorization";

    /**
     * JWT令牌前缀
     */
    String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * 用户信息Http请求头
     */
    String USER_TOKEN_HEADER = "user";

    /**
     * sa-token session中存储的会员信息
     */
    String STP_MEMBER_INFO = "memberInfo";

    /**
     * sa-token session中存储的后台管理员信息
     */
    String STP_ADMIN_INFO = "adminInfo";
}
    