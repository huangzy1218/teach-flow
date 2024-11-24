package domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 课程资源。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 23:43
 */
@TableName(value = "resource")
@Data
public class Resource implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -2703752212050771081L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 所有者 ID
     */
    @JsonProperty("admin_id")
    private Integer adminId;

    /**
     * 类型
     */
    private String type;

    /**
     * 资源名
     */
    private String name;

    /**
     * 文件类型
     */
    private String extension;

    /**
     * 大小[字节]
     */
    private Long size;

    /**
     * 存储磁盘
     */
    private String disk;

    /**
     * 文件id
     */
    @JsonProperty("file_id")
    private String fileId;

    /**
     * 相对地址
     */
    private String path;

    /**
     * URL地址
     */
    private String url;

    /**
     *
     */
    @JsonProperty("created_at")
    private Date createdAt;

    /**
     * 所属素材
     */
    @JsonProperty("parent_id")
    private Integer parentId;

    /**
     * 隐藏[0:否,1:是]
     */
    @JsonIgnore
    private Integer isHidden;
}
    