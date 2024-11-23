package cn.edu.nwafu.cie.teach.user.domain;

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
 * 管理角色。
 *
 * @author Huang Z.Y.
 * @create 2024-11-24 00:20
 */
@TableName(value = "admin_role")
@Data
public class AdminRole implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 5656137801666599967L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * slug
     */
    private String slug;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;
}
    