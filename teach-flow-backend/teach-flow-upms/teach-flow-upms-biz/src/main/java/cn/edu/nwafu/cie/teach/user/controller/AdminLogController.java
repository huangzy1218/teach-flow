package cn.edu.nwafu.cie.teach.user.controller;

import cn.edu.nwafu.cie.teach.common.api.R;
import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 管理员日志控制器。
 *
 * @author Huang Z.Y.
 * @create 2024-11-28 22:49
 */
@RestController
@Slf4j
@RequestMapping("/v1/admin/log")
public class AdminLogController {
    @Log("管理员日志-列表")
    @GetMapping("/index")
    public R index(@RequestParam HashMap<String, Object> params) {
        return R.success();
    }

    @Log("管理员日志-详情")
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable(name = "id") Integer id) {
        return R.success();
    }
}
    