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
 * 课时。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 23:06
 */
@TableName(value = "course_hour")
@Data
public class CourseHour implements Serializable {
    @TableField(exist = false)
    @Serial
    private static final long serialVersionUID = -5218072063342998381L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 课程 ID
     */
    @JsonProperty("course_id")
    private Integer courseId;

    /**
     * 章节 ID
     */
    @JsonProperty("chapter_id")
    private Integer chapterId;

    /**
     * 升序
     */
    private Integer sort;

    /**
     * 课时名
     */
    private String title;

    /**
     * 课时类型
     */
    private String type;

    /**
     * 资源 ID
     */
    private Integer rid;

    /**
     * 时长[s]
     */
    private Integer duration;

    /**
     * 创建时间
     */
    @JsonIgnore
    private Date createdAt;
}
    