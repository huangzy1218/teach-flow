package cn.edu.nwafu.cie.teach.course.controller;

import cn.edu.nwafu.cie.teach.common.api.R;
import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Huang Z.Y.
 * @create 2024-12-02 22:09
 */
@RestController
@RequestMapping("/v1/dashboard")
public class DashboardController {
    @GetMapping("/index")
    @Log("主面板")
    public R index() {
        return R.success();
    }
}
    