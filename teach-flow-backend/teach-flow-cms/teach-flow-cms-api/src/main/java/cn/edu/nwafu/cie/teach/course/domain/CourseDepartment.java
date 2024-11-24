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
 * 课程部门。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 22:58
 */
@TableName(value = "course_department")
@Data
public class CourseDepartment implements Serializable {
    @TableField(exist = false)
    @Serial
    private static final long serialVersionUID = -4153920976202998248L;

    @TableId(type = IdType.NONE)
    @JsonProperty("course_id")
    private Integer courseId;

    @JsonProperty("dep_id")
    private Integer depId;
}
    