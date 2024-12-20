package cn.edu.nwafu.cie.teach.common.log.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * 日志配置类。
 *
 * @author Huang Z.Y.
 * @create 2024-11-25 00:28
 */
@Getter
@Setter
@ConfigurationProperties(LogProperties.PREFIX)
public class LogProperties {
    public static final String PREFIX = "security.log";

    /**
     * 开启日志记录
     */
    private boolean enabled = true;

    /**
     * 放行字段，password,mobile,idcard,phone
     */
    @Value("${security.log.exclude-fields:password,mobile,idcard,phone}")
    private List<String> excludeFields;

    /**
     * 请求报文最大存储长度
     */
    private Integer maxLength = 2000;
}
    