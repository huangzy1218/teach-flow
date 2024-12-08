package cn.edu.nwafu.cie.teach.course.controller;

import cn.edu.nwafu.cie.teach.common.api.R;
import cn.edu.nwafu.cie.teach.common.exception.NotFoundException;
import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import cn.edu.nwafu.cie.teach.course.request.CourseChapterRequest;
import cn.edu.nwafu.cie.teach.course.request.CourseChapterSortRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Huang Z.Y.
 * @create 2024-12-01 23:51
 */
@RestController
@RequestMapping("/v1/course/{courseId}/chapter")
public class CourseChapterController {
    @PostMapping("/create")
    @Log("线上课-章节-新建")
    public R store(
            @PathVariable(name = "courseId") Integer courseId,
            @RequestBody @Validated CourseChapterRequest req) {
        return R.success();
    }

    @GetMapping("/{id}")
    @Log("线上课-章节-查询")
    public R query(
            @PathVariable(name = "courseId") Integer courseId,
            @PathVariable(name = "id") Integer id)
            throws NotFoundException {
        return R.success();
    }

    @PutMapping("/{id}")
    @Log("线上课-章节-编辑")
    public R update(
            @PathVariable(name = "courseId") Integer courseId,
            @PathVariable(name = "id") Integer id,
            @RequestBody @Validated CourseChapterRequest req)
            throws NotFoundException {
        return R.success();
    }

    @DeleteMapping("/{id}")
    @Log("线上课-章节-删除")
    public R delete(
            @PathVariable(name = "courseId") Integer courseId,
            @PathVariable(name = "id") Integer id)
            throws NotFoundException {
        return R.success();
    }

    @PutMapping("/update/sort")
    @Log("线上课-章节-更新排序")
    public R updateSort(
            @PathVariable(name = "courseId") Integer courseId,
            @RequestBody @Validated CourseChapterSortRequest req) {
        return R.success();
    }
}
