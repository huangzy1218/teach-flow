package cn.edu.nwafu.cie.teach.user.controller;

import cn.edu.nwafu.cie.teach.common.api.R;
import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import cn.edu.nwafu.cie.teach.user.api.request.LoginRequest;
import cn.edu.nwafu.cie.teach.user.api.request.PasswordChangeRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 登录 / 登出控制器。
 *
 * @author Huang Z.Y.
 * @create 2024-11-28 23:55
 */
@RestController
@RequestMapping("/v1/auth")
public class LoginController {
    @PostMapping("/login")
    @Log("管理员-登录")
    public R login(@RequestBody @Validated LoginRequest loginRequest) {
        return R.success();
    }

    @PostMapping("/logout")
    @Log("管理员-登出")
    public R logout() {
        return R.success();
    }

    @GetMapping("/detail")
    @Log("管理员-详情")
    public R detail() {
        return R.success();
    }

    @PutMapping("/password")
    @Log("管理员-密码修改")
    public R changePassword(@RequestBody @Validated PasswordChangeRequest req) {
        return R.success();
    }
}
    