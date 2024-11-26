package cn.edu.nwafu.cie.teach.user.api.domain;

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
 * 学院。
 *
 * @author Huang Z.Y.
 * @create 2024-11-24 00:37
 */
@TableName(value = "department")
@Data
public class Department implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -6651105817842882083L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 部门名
     */
    private String name;

    /**
     * 父id
     */
    @JsonProperty("parent_id")
    private Integer parentId;

    /**
     * 父链
     */
    @JsonProperty("parent_chain")
    private String parentChain;

    /**
     * 升序
     */
    private Integer sort;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;
}
    