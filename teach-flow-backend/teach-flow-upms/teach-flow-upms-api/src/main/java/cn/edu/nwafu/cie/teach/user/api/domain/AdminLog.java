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
 * 管理日志。
 *
 * @author Huang Z.Y.
 * @create 2024-11-24 00:10
 */
@TableName(value = "admin_log")
@Data
public class AdminLog implements Serializable {
    @TableField(exist = false)
    @Serial
    private static final long serialVersionUID = 3372166860180045689L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 管理员 ID
     */
    @JsonProperty("admin_id")
    private Integer adminId;

    /**
     * 管理员姓名
     */
    @JsonProperty("admin_name")
    private String adminName;

    /**
     * 模块
     */
    private String module;

    /**
     * 标题
     */
    private String title;

    /**
     * 操作指令
     */
    private Integer opt;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求方式 POST,GET,PUT,DELETE
     */
    @JsonProperty("request_method")
    private String requestMethod;

    /**
     * 请求 URL
     */
    private String url;

    /**
     * 请求参数
     */
    private String param;

    /**
     * 返回参数
     */
    private String result;

    /**
     * ip
     */
    private String ip;

    /**
     * 地址
     */
    @JsonProperty("ip_area")
    private String ipArea;

    /**
     * 备注
     */
    @JsonProperty("error_msg")
    private String errorMsg;

    @JsonProperty("created_at")
    private Date createdAt;
}
    