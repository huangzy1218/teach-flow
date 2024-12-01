package cn.edu.nwafu.cie.teach.user.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 修改密码请求体。
 *
 * @author Huang Z.Y.
 * @create 2024-12-01 22:27
 */
@Data
public class PasswordChangeRequest {
    @JsonProperty("old_password")
    @NotBlank(message = "请输入原密码")
    private String oldPassword;

    @JsonProperty("new_password")
    @NotBlank(message = "请输入新密码")
    private String newPassword;
}
    