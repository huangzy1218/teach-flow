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
 * 用户学习时长统计。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 23:30
 */
@TableName(value = "user_learn_duration_stats")
@Data
public class UserLearnDurationStats implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -7451853528626053081L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    @JsonProperty("user_id")
    private Integer userId;

    /**
     * 学习时长
     */
    private Long duration;

    @JsonProperty("created_date")
    private Date createdDate;
}
    