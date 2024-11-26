package cn.edu.nwafu.cie.teach.common.file.local;

import cn.edu.nwafu.cie.teach.common.file.core.FileProperties;
import cn.edu.nwafu.cie.teach.common.file.core.FileTemplate;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * aws 自动配置。
 *
 * @author Huang Z.Y.
 * @create 2024-11-27 00:14
 */
@AllArgsConstructor
public class LocalFileAutoConfig {
    private final FileProperties properties;

    @Bean
    @ConditionalOnMissingBean(LocalFileTemplate.class)
    @ConditionalOnProperty(name = "file.local.enable", havingValue = "true", matchIfMissing = true)
    public FileTemplate localFileTemplate() {
        return new LocalFileTemplate(properties);
    }
}
    