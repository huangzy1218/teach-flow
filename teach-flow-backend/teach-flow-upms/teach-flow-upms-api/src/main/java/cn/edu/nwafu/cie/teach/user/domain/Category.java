package cn.edu.nwafu.cie.teach.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * 分类。
 *
 * @author Huang Z.Y.
 * @create 2024-11-24 00:33
 */
@TableName(value = "resource_category")
@Data
public class Category {
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 父 ID
     */
    @JsonProperty("parent_id")
    private Integer parentId;

    /**
     * 父链
     */
    @JsonProperty("parent_chain")
    private String parentChain;

    /**
     * 分类名
     */
    private String name;

    /**
     * 升序
     */
    private Integer sort;

    @JsonIgnore
    private Date createdAt;

    @JsonIgnore
    private Date updatedAt;
}
    