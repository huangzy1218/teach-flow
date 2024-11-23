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
 * 用户课程时数记录。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 23:10
 */
@TableName(value = "user_course_hour_records")
@Data
public class UserCourseHourRecord implements Serializable {
    @TableField(exist = false)
    @Serial
    private static final long serialVersionUID = 1693892773634877650L;
    
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户 ID
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * 课程 ID
     */
    @JsonProperty("course_id")
    private Integer courseId;

    /**
     * 课时 ID
     */
    @JsonProperty("hour_id")
    private Integer hourId;

    /**
     * 总时长
     */
    @JsonProperty("total_duration")
    private Integer totalDuration;

    /**
     * 已完成时长
     */
    @JsonProperty("finished_duration")
    private Integer finishedDuration;

    /**
     * 实际观看时长
     */
    @JsonProperty("real_duration")
    private Integer realDuration;

    /**
     * 是否看完[1:是,0:否]
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
    