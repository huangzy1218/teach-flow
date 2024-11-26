package cn.edu.nwafu.cie.teach.user.api.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户上传图片日志。
 *
 * @author Huang Z.Y.
 * @create 2024-11-24 00:44
 */
@TableName(value = "user_upload_image_log")
@Data
public class UserUploadImageLog implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 40037032058972791L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    @JsonProperty("user_id")
    private Integer userId;

    /**
     * 图片类型
     */
    private String typed;

    /**
     * 上传场景
     */
    private String scene;

    /**
     * 驱动
     */
    private String driver;

    /**
     * 相对路径
     */
    private String path;

    /**
     * 访问地址
     */
    private String url;

    /**
     * 大小,单位:字节
     */
    private Long size;

    /**
     * 文件名
     */
    private String name;

    @JsonProperty("created_at")
    private Date createdAt;
}
    