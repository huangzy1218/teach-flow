package cn.edu.nwafu.cie.teach.user.controller;

import cn.edu.nwafu.cie.teach.common.api.R;
import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import cn.edu.nwafu.cie.teach.user.api.request.AdminRoleRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员角色控制器。
 *
 * @author Huang Z.Y.
 * @create 2024-11-28 23:18
 */
@RestController
@RequestMapping("/v1/admin-role")
@Slf4j
public class AdminRoleController {
    @GetMapping("/index")
    @Log("管理员角色-列表")
    public R index() {
        return R.success();
    }

    @GetMapping("/create")
    @Log("管理员角色-新建")
    public R create() {
        return R.success();
    }

    @GetMapping("/{id}")
    @Log("管理员角色-查询")
    public R find(@PathVariable(name = "id") Integer id) {
        return R.success();
    }

    @PutMapping("/{id}")
    @Log("管理员角色-编辑")
    public R update(@PathVariable(name = "id") Integer id, @RequestBody @Validated AdminRoleRequest request) {
        return R.success();
    }

    @DeleteMapping("/{id}")
    @Log("管理员角色-删除")
    public R delete(@PathVariable(name = "id") Integer id) {
        return R.success();
    }
}
    