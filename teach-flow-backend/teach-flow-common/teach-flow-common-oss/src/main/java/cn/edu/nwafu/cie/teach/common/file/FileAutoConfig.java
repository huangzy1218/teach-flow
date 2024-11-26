package cn.edu.nwafu.cie.teach.common.file;

import cn.edu.nwafu.cie.teach.common.file.core.FileProperties;
import cn.edu.nwafu.cie.teach.common.file.local.LocalFileAutoConfig;
import cn.edu.nwafu.cie.teach.common.file.oss.OssAutoConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

/**
 * aws 自动配置类。
 *
 * @author Huang Z.Y.
 * @create 2024-11-27 00:13
 */
@Import({LocalFileAutoConfig.class, OssAutoConfig.class})
@EnableConfigurationProperties({FileProperties.class})
public class FileAutoConfig {
}
    