package cn.edu.nwafu.cie.teach.common.file.oss;

import cn.edu.nwafu.cie.teach.common.file.core.FileProperties;
import cn.edu.nwafu.cie.teach.common.file.core.FileTemplate;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * AMS 自动配置类。
 *
 * @author Huang Z.Y.
 * @create 2024-11-27 00:29
 */
@AllArgsConstructor
public class OssAutoConfig {
    private final FileProperties properties;

    @Bean
    @Primary
    @ConditionalOnMissingBean(OssTemplate.class)
    @ConditionalOnProperty(name = "file.oss.enable", havingValue = "true")
    public FileTemplate ossTemplate() {
        return new OssTemplate(properties);
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "file.oss.info", havingValue = "true")
    public OssEndpoint ossEndpoint(OssTemplate template) {
        return new OssEndpoint(template);
    }
}
    