package cn.edu.nwafu.cie.teach.course.domain;

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
 * 课程章节。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 22:57
 */
@TableName(value = "course_chapters")
@Data
public class CourseChapter implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -5883669980962166551L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 课程 ID
     */
    @JsonProperty("course_id")
    private Integer courseId;

    /**
     * 章节名
     */
    private String name;

    /**
     * 升序
     */
    private Integer sort;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;
}
    