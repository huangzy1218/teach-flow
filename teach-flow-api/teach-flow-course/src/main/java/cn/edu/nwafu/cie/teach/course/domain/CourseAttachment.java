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
 * 课程附件。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 22:32
 */
@TableName(value = "course_attachment")
@Data
public class CourseAttachment implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -354675770769700687L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 课程 ID
     */
    @JsonProperty("course_id")
    private Integer courseId;

    /**
     * 升序
     */
    private Integer sort;

    /**
     * 附件名
     */
    private String title;

    /**
     * 类型
     */
    private String type;

    /**
     * 资源 ID
     */
    private Integer rid;

    /**
     * 资源 URL
     */
    @TableField(exist = false)
    private String url;

    /**
     * 资源类型
     */
    @TableField(exist = false)
    private String ext;

    /**
     * 创建时间
     */
    @JsonIgnore
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
        CourseAttachment other = (CourseAttachment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCourseId() == null
                ? other.getCourseId() == null
                : this.getCourseId().equals(other.getCourseId()))
                && (this.getSort() == null
                ? other.getSort() == null
                : this.getSort().equals(other.getSort()))
                && (this.getTitle() == null
                ? other.getTitle() == null
                : this.getTitle().equals(other.getTitle()))
                && (this.getExt() == null
                ? other.getExt() == null
                : this.getExt().equals(other.getExt()))
                && (this.getType() == null
                ? other.getType() == null
                : this.getType().equals(other.getType()))
                && (this.getRid() == null
                ? other.getRid() == null
                : this.getRid().equals(other.getRid()))
                && (this.getUrl() == null
                ? other.getUrl() == null
                : this.getUrl().equals(other.getUrl()))
                && (this.getCreatedAt() == null
                ? other.getCreatedAt() == null
                : this.getCreatedAt().equals(other.getCreatedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getExt() == null) ? 0 : getExt().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getRid() == null) ? 0 : getRid().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseId=").append(courseId);
        sb.append(", sort=").append(sort);
        sb.append(", title=").append(title);
        sb.append(", ext=").append(ext);
        sb.append(", type=").append(type);
        sb.append(", rid=").append(rid);
        sb.append(", url=").append(url);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
    