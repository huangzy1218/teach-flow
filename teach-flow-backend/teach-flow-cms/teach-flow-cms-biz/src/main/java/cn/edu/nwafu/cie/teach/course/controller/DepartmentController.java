package cn.edu.nwafu.cie.teach.course.controller;

import cn.edu.nwafu.cie.teach.common.api.R;
import cn.edu.nwafu.cie.teach.common.exception.NotFoundException;
import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import cn.edu.nwafu.cie.teach.course.request.DepartmentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Huang Z.Y.
 * @create 2024-12-02 22:11
 */
@RestController
@Slf4j
@RequestMapping("/backend/v1/department")
public class DepartmentController {
    @GetMapping("/index")
    @Log("部门-列表")
    public R index() {
        return R.success();
    }

    @GetMapping("/departments")
    @Log("部门-全部部门")
    public R index(
            @RequestParam(name = "parent_id", defaultValue = "0") Integer parentId) {
        return R.success();
    }

    @GetMapping("/create")
    @Log("部门-查询")
    public R query() {
        return R.success();
    }

    @PostMapping("/create")
    @Log("部门-新建")
    public R store(@RequestBody @Validated DepartmentRequest req) {
        return R.success();
    }

    @GetMapping("/{id}")
    @Log("部门-查询")
    public R query(@PathVariable Integer id) throws NotFoundException {
        return R.success();
    }

    @PutMapping("/{id}")
    @Log("部门-编辑")
    public R update(@PathVariable Integer id, @RequestBody DepartmentRequest req) {
        return R.success();
    }

    @DeleteMapping("/{id}")
    @Log("部门-删除")
    public R delete(@PathVariable Integer id) throws NotFoundException {
        return R.success();
    }
}
    