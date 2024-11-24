package domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 视频资源。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 23:50
 */
@TableName(value = "resource_videos")
@Data
public class ResourceVideo implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -711545911833062231L;

    @TableId(type = IdType.NONE)
    private Integer rid;

    /**
     * 封面
     */
    private String poster;

    /**
     * 视频时长[s]
     */
    private Integer duration;

    @JsonIgnore
    private Date createdAt;

}
    