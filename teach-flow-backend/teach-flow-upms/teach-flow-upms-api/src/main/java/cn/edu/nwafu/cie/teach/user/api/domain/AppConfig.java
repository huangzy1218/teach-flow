package cn.edu.nwafu.cie.teach.user.api.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * 应用配置信息。
 *
 * @author Huang Z.Y.
 * @create 2024-11-24 00:30
 */
@TableName(value = "app_config")
@Data
public class AppConfig {
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 分组
     */
    @JsonProperty("group_name")
    private String groupName;

    /**
     * 名称
     */
    private String name;

    /**
     * 升序
     */
    private Integer sort;

    /**
     * 域类型
     */
    @JsonProperty("field_type")
    private String fieldType;

    /**
     * 键
     */
    @JsonProperty("key_name")
    private String keyName;

    /**
     * 值
     */
    @JsonProperty("key_value")
    private String keyValue;

    /**
     * 可选值
     */
    @JsonProperty("option_value")
    private String optionValue;

    /**
     * 是否私密信息
     */
    @JsonProperty("is_private")
    private Integer isPrivate;

    /**
     * 帮助信息
     */
    private String help;

    /**
     *
     */
    @JsonIgnore
    private Date createdAt;

    /**
     * 1　显示，0　否
     */
    @JsonIgnore
    private Integer isHidden;

    @JsonGetter("key_value")
    public String transformKeyValue() {
        return isHidden == 1 ? "******" : keyValue;
    }
}
    