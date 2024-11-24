package cn.edu.nwafu.cie.teach.course.domain;

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
 * 课程附件。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 22:32
 */
@TableName(value = "course_attachment")
@Data
public class CourseAttachment implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -354675770769700687L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 课程 ID
     */
    @JsonProperty("course_id")
    private Integer courseId;

    /**
     * 升序
     */
    private Integer sort;

    /**
     * 附件名
     */
    private String title;

    /**
     * 类型
     */
    private String type;

    /**
     * 资源 ID
     */
    private Integer rid;

    /**
     * 资源 URL
     */
    @TableField(exist = false)
    private String url;

    /**
     * 资源类型
     */
    @TableField(exist = false)
    private String ext;

    /**
     * 创建时间
     */
    @JsonIgnore
    private Date createdAt;
}
    