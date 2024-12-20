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
 * 课程表。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 22:07
 */
@TableName(value = "course")
@Data
public class Course implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 5390233735144466386L;
    
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 课程标题
     */
    private String title;

    /**
     * 课程封面
     */
    private String thumb;

    /**
     * 课程价格(分)
     */
    private Integer charge;

    /**
     * 课程简介
     */
    @JsonProperty("short_desc")
    private String shortDesc;

    /**
     * 1:必修,0:选修
     */
    @JsonProperty("is_required")
    private Integer isRequired;

    /**
     * 课时数
     */
    @JsonProperty("class_hour")
    private Integer classHour;

    /**
     * 显示[1:是,0:否]
     */
    @JsonProperty("is_show")
    private Integer isShow;

    @JsonProperty("published_at")
    private Date publishedAt;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("admin_id")
    private Integer adminId;

    @JsonIgnore
    private Date updatedAt;

    @JsonIgnore
    private Date deletedAt;
}
    