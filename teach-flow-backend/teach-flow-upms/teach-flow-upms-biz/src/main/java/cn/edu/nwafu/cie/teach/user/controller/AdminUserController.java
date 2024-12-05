package cn.edu.nwafu.cie.teach.user.controller;

import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import cn.edu.nwafu.cie.teach.common.util.R;
import cn.edu.nwafu.cie.teach.user.api.request.AdminUserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author Huang Z.Y.
 * @create 2024-11-28 23:27
 */
@RestController
@Slf4j
@RequestMapping("/v1/admin-user")
public class AdminUserController {
    @GetMapping("/index")
    @Log("管理员-列表")
    public R index(@RequestParam HashMap<String, Object> params) {
        return R.success();
    }

    @GetMapping("/list")
    @Log("管理员-查看")
    public R list() {
        return R.success();
    }

    @PostMapping("/create")
    @Log("管理员-新建")
    public R create(@RequestBody AdminUserRequest req) {
        return R.success();
    }

    @GetMapping("/{id}")
    @Log("管理员-查询")
    public R find(@PathVariable Integer id) {
        return R.success();
    }

    @PutMapping("/{id}")
    @Log("管理员-编辑")
    public R update(@PathVariable Integer id,
                    @RequestBody @Validated AdminUserRequest req) {
        return R.success();
    }

    @DeleteMapping("/{id}")
    @Log("管理员-删除")
    public R delete(@PathVariable Integer id) {
        return R.success();
    }
}
    