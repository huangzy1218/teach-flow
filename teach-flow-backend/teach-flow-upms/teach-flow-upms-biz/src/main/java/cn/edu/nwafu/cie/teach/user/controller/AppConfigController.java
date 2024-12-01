package cn.edu.nwafu.cie.teach.user.controller;

import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import cn.edu.nwafu.cie.teach.common.util.R;
import cn.edu.nwafu.cie.teach.user.api.request.AppConfigRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 应用配置控制器。
 *
 * @author Huang Z.Y.
 * @create 2024-11-28 23:49
 */
@RequestMapping("/v1/app-config")
public class AppConfigController {
    @GetMapping("")
    @Log("系统配置-读取")
    public R index() {
        return R.success();
    }

    @PutMapping("")
    @Log("系统配置-保存")
    public R save(@RequestBody AppConfigRequest req) {
        return R.success();
    }
}
    