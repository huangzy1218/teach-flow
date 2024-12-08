package cn.edu.nwafu.cie.teach.course.controller;

import cn.edu.nwafu.cie.teach.common.api.R;
import cn.edu.nwafu.cie.teach.common.exception.NotFoundException;
import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import cn.edu.nwafu.cie.teach.course.request.CourseAttachmentMultiRequest;
import cn.edu.nwafu.cie.teach.course.request.CourseAttachmentRequest;
import cn.edu.nwafu.cie.teach.course.request.CourseAttachmentSortRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Huang Z.Y.
 * @create 2024-12-01 22:59
 */
@RestController
@Slf4j
@RequestMapping("/v1/course/{courseId}/attachment")
public class CourseAttachmentController {
    @PostMapping("/create")
    @Log("线上课-附件-新建")
    public R store(
            @PathVariable(name = "courseId") Integer courseId,
            @RequestBody @Validated CourseAttachmentRequest req)
            throws NotFoundException {
        return R.success();
    }

    @PostMapping("/create-batch")
    @Transactional
    @Log("线上课-附件-批量新建")
    public R storeBatch(@PathVariable(name = "courseId") Integer courseId,
                        @RequestBody @Validated CourseAttachmentMultiRequest req) {
        return R.success();
    }

    @GetMapping("/{id}")
    @Log("线上课-附件-查询")
    public R find(
            @PathVariable(name = "courseId") Integer courseId,
            @PathVariable(name = "id") Integer id)
            throws NotFoundException {
        return R.success();
    }

    @PutMapping("/{id}")
    @Log("线上课-附件-编辑")
    public R update(
            @PathVariable(name = "courseId") Integer courseId,
            @PathVariable(name = "id") Integer id,
            @RequestBody @Validated CourseAttachmentRequest req)
            throws NotFoundException {
        return R.success();
    }

    @DeleteMapping("/{id}")
    @Log("线上课-附件-删除")
    public R delete(
            @PathVariable(name = "courseId") Integer courseId,
            @PathVariable(name = "id") Integer id) {
        return R.success();
    }

    @PutMapping("/update/sort")
    @Log("线上课-附件-排序调整")
    public R updateSort(
            @PathVariable(name = "courseId") Integer courseId,
            @RequestBody @Validated CourseAttachmentSortRequest req) {
        return R.success();
    }
}
    