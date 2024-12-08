package cn.edu.nwafu.cie.teach.course.controller;

import cn.edu.nwafu.cie.teach.common.api.R;
import cn.edu.nwafu.cie.teach.common.exception.NotFoundException;
import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import cn.edu.nwafu.cie.teach.course.request.CourseHourBatchRequest;
import cn.edu.nwafu.cie.teach.course.request.CourseHourRequest;
import cn.edu.nwafu.cie.teach.course.request.CourseHourSortRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Huang Z.Y.
 * @create 2024-12-02 21:51
 */
@RestController
@Slf4j
@RequestMapping("/v1/course/{courseId}/hour")
public class CourseHourController {
    @GetMapping("/create")
    @Log("线上课-课时-新建")
    public R create(@PathVariable(name = "courseId") Integer courseId) {
        return R.success();
    }

    @PostMapping("/create")
    @Log("线上课-课时-新建")
    public R create(
            @PathVariable(name = "courseId") Integer courseId,
            @RequestBody @Validated CourseHourRequest req)
            throws NotFoundException {
        return R.success();
    }

    @PostMapping("/create-batch")
    @Transactional
    @Log("线上课-课时-批量导入")
    public R createBatch(
            @PathVariable(name = "courseId") Integer courseId,
            @RequestBody @Validated CourseHourBatchRequest req) {
        return R.success();
    }

    @GetMapping("/{id}")
    @Log("线上课-课时-查询")
    public R query(
            @PathVariable(name = "courseId") Integer courseId,
            @PathVariable(name = "id") Integer id)
            throws NotFoundException {
        return R.success();
    }

    @PutMapping("/{id}")
    @Log("线上课-课时-编辑")
    public R update(
            @PathVariable(name = "courseId") Integer courseId,
            @PathVariable(name = "id") Integer id,
            @RequestBody @Validated CourseHourRequest req)
            throws NotFoundException {
        return R.success();
    }

    @DeleteMapping("/{id}")
    @Log("线上课-课时-删除")
    public R delete(
            @PathVariable(name = "courseId") Integer courseId,
            @PathVariable(name = "id") Integer id)
            throws NotFoundException {
        return R.success();
    }

    @PutMapping("/update/sort")
    @Log("线上课-课时-更新排序")
    public R updateSort(
            @PathVariable(name = "courseId") Integer courseId,
            @RequestBody @Validated CourseHourSortRequest req) {
        return R.success();
    }
}
    