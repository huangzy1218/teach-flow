package cn.edu.nwafu.cie.teach.common.log;

import cn.edu.nwafu.cie.teach.common.log.aspect.LogAspect;
import cn.edu.nwafu.cie.teach.common.log.config.LogProperties;
import cn.edu.nwafu.cie.teach.common.log.event.LogListener;
import cn.edu.nwafu.cie.teach.user.api.feign.RemoteLogService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Huang Z.Y.
 * @create 2024-11-26 23:29
 */
@EnableAsync
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(LogProperties.class)
@ConditionalOnProperty(value = "security.log.enabled", matchIfMissing = true)
public class LogAutoConfig {
    @Bean
    public LogListener sysLogListener(LogProperties logProperties, RemoteLogService remoteLogService) {
        return new LogListener(remoteLogService, logProperties);
    }

    @Bean
    public LogAspect sysLogAspect() {
        return new LogAspect();
    }
}
    