package cn.edu.nwafu.cie.teach.common.file.oss;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * aws 配置。
 *
 * @author Huang Z.Y.
 * @create 2024-11-27 00:26
 */
@Data
@ConfigurationProperties(prefix = "oss")
public class OssProperties {
    /**
     * 对象存储服务的URL
     */
    private String endpoint;

    /**
     * 自定义域名
     */
    private String customDomain;

    /**
     * <ul>
     *  <li>true path-style nginx 反向代理和S3默认支持 pathStyle {http://endpoint/bucketname}</li>
     *  <li>false supports virtual-hosted-style 阿里云等需要配置为 virtual-hosted-style 模式 {http://bucketname.endpoint}</li>
     * </ul>
     */
    private Boolean pathStyleAccess = true;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 区域
     */
    private String region;

    /**
     * Access key就像用户ID，可以唯一标识你的账户
     */
    private String accessKey;

    /**
     * Secret key是你账户的密码
     */
    private String secretKey;

    /**
     * 最大线程数，默认： 100
     */
    private Integer maxConnections = 100;
}
    