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
 * 课程附件下载日志。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 22:49
 */
@TableName(value = "course_attachment_download_log")
@Data
public class CourseAttachmentDownloadLog implements Serializable {
    @TableField(exist = false)
    @Serial
    private static final long serialVersionUID = 5906686862645562336L;


    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 学员 ID
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * 课程 ID
     */
    @JsonProperty("course_id")
    private Integer courseId;

    /**
     * 标题
     */
    private String title;

    /**
     * 课程附件 ID
     */
    @JsonProperty("courser_attachment_id")
    private Integer courserAttachmentId;
    
    /**
     * 资源ID
     */
    private Integer rid;

    /**
     * IP
     */
    private String ip;

    @JsonProperty("created_at")
    private Date createdAt;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CourseAttachmentDownloadLog other = (CourseAttachmentDownloadLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getUserId() == null
                ? other.getUserId() == null
                : this.getUserId().equals(other.getUserId()))
                && (this.getCourseId() == null
                ? other.getCourseId() == null
                : this.getCourseId().equals(other.getCourseId()))
                && (this.getTitle() == null
                ? other.getTitle() == null
                : this.getTitle().equals(other.getTitle()))
                && (this.getCourserAttachmentId() == null
                ? other.getCourserAttachmentId() == null
                : this.getCourserAttachmentId().equals(other.getCourserAttachmentId()))
                && (this.getRid() == null
                ? other.getRid() == null
                : this.getRid().equals(other.getRid()))
                && (this.getIp() == null
                ? other.getIp() == null
                : this.getIp().equals(other.getIp()))
                && (this.getCreatedAt() == null
                ? other.getCreatedAt() == null
                : this.getCreatedAt().equals(other.getCreatedAt()));
    }
}
    