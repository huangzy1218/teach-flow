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
 * 用户学习时长记录。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 23:28
 */
@TableName(value = "user_learn_duration_records")
@Data
public class UserLearnDurationRecord implements Serializable {
    @TableField(exist = false)
    @Serial
    private static final long serialVersionUID = -6597984527255146071L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("created_date")
    private Date createdDate;

    /**
     * 已学习时长[微秒]
     */
    private Integer duration;

    /**
     * 开始时间
     */
    @JsonProperty("start_at")
    private Date startAt;

    /**
     * 结束时间
     */
    @JsonProperty("end_at")
    private Date endAt;

    @JsonProperty("course_id")
    private Integer courseId;

    @JsonProperty("hour_id")
    private Integer hourId;
}
    