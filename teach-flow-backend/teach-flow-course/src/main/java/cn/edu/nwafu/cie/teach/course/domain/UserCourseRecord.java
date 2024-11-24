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
 * 用户课程记录。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 23:20
 */
@TableName(value = "user_course_records")
@Data
public class UserCourseRecord implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 8391232609105792199L;
    
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户 ID
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     *
     */
    @JsonProperty("course_id")
    private Integer courseId;

    /**
     * 课时数量
     */
    @JsonProperty("hour_count")
    private Integer hourCount;

    /**
     * 已完成课时数
     */
    @JsonProperty("finished_count")
    private Integer finishedCount;

    /**
     * 进度
     */
    private Integer progress;

    /**
     * 看完[1:是,0:否]
     */
    @JsonProperty("is_finished")
    private Integer isFinished;

    /**
     * 结束时间
     */
    @JsonProperty("finished_at")
    private Date finishedAt;

    /**
     * 创建时间
     */
    @JsonProperty("created_at")
    private Date createdAt;

    /**
     * 更新时间
     */
    @JsonProperty("updated_at")
    private Date updatedAt;
}
    