package cn.edu.nwafu.cie.teach.user.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

/**
 * 管理员用户请求体，
 *
 * @author Huang Z.Y.
 * @create 2024-11-28 23:41
 */
public class AdminUserRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 7719621070294129972L;

    @NotBlank(message = "请输入管理员姓名")
    @Length(min = 1, max = 12, message = "管理员姓名长度在1-12个字符之间")
    private String name;

    @NotBlank(message = "请输入管理员邮箱")
    @Email(message = "请输入合法邮箱")
    private String email;

    @NotNull(message = "password参数不存在")
    private String password;

    @JsonProperty("is_ban_login")
    @NotNull(message = "is_ban_login参数不存在")
    private Integer isBanLogin;

    @JsonProperty("role_ids")
    @NotNull(message = "role_ids参数不存在")
    private Integer[] roleIds;
}
    