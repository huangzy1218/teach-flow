package cn.edu.nwafu.cie.teach.common.file.core;

import cn.edu.nwafu.cie.teach.common.file.local.LocalFileProperties;
import cn.edu.nwafu.cie.teach.common.file.oss.OssProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 文件配置信息。
 *
 * @author Huang Z.Y.
 * @create 2024-11-27 00:23
 */
@Data
@ConfigurationProperties(prefix = "file")
public class FileProperties {
    /**
     * 默认的存储桶名称
     */
    private String bucketName = "local";

    /**
     * 本地文件配置信息
     */
    private LocalFileProperties local;

    /**
     * oss 文件配置信息
     */
    private OssProperties oss;
}
    