package cn.edu.nwafu.cie.teach.user.api.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 登录请求体。
 *
 * @author Huang Z.Y.
 * @create 2024-12-01 22:24
 */
@Data
public class LoginRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 6446046062863887185L;

    @NotNull(message = "请输入邮箱")
    public String email;

    @NotNull(message = "请输入密码")
    public String password;
}
    