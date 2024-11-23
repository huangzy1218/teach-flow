package cn.edu.nwafu.cie.teach.course.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 课程分类。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 22:53
 */
@TableName(value = "resource_course_category")
@Data
public class CourseCategory implements Serializable {
    @TableField(exist = false)
    @Serial
    private static final long serialVersionUID = -4874858215277497569L;

    /**
     * 课程 ID
     */
    @TableId(type = IdType.NONE)
    @JsonProperty("course_id")
    private Integer courseId;

    /**
     * 分类 ID
     */
    @JsonProperty("category_id")
    private Integer categoryId;

}
    