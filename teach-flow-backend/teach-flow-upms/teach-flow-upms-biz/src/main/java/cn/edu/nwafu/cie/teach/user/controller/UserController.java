package cn.edu.nwafu.cie.teach.user.controller;

import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import cn.edu.nwafu.cie.teach.common.util.R;
import cn.edu.nwafu.cie.teach.user.api.request.UserImportRequest;
import cn.edu.nwafu.cie.teach.user.api.request.UserRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 用户控制器。
 *
 * @author Huang Z.Y.
 * @create 2024-12-01 22:29
 */
@RestController
@Slf4j
@RequestMapping("/v1/user")
public class UserController {
    @GetMapping("/index")
    @Log("学生-列表")
    public R index(@RequestParam HashMap<String, Object> params) {
        return R.success();
    }

    @PostMapping("/create")
    @Log("学生-新建")
    public R create(@RequestBody @Validated UserRequest req) {
        return R.success();
    }

    @GetMapping("/{id}")
    @Log("学生-查询")
    public R detail(@PathVariable(name = "id") Integer id) {
        return R.success();
    }

    @PutMapping("/{id}")
    @Transactional
    @Log("学生-编辑")
    public R update(@PathVariable(name = "id") Integer id, @RequestBody @Validated UserRequest req) {
        return R.success();
    }

    @DeleteMapping("/{id}")
    @Log("学生-删除")
    public R delete(@PathVariable(name = "id") Integer id) {
        return R.success();
    }

    @PostMapping("/store-batch")
    @Transactional
    @Log("学生-批量导入")
    public R batchStore(@RequestBody @Validated UserImportRequest req) {
        return R.success();
    }

    @GetMapping("/{id}/learn-hours")
    @SneakyThrows
    @Log("学生-学习时长")
    public R learnHours(
            @PathVariable(name = "id") Integer id, @RequestParam HashMap<String, Object> params) {
        return R.success();
    }

    @GetMapping("/{id}/learn-courses")
    @Log("学生-最新学习课程")
    public R latestLearnCourses(
            @PathVariable(name = "id") Integer id, @RequestParam HashMap<String, Object> params) {
        return R.success();
    }

    @GetMapping("/{id}/all-courses")
    @Log("学生-课程")
    public R allCourses(@PathVariable(name = "id") Integer id) {
        return R.success();
    }

    @GetMapping("/{id}/learn-course/{courseId}")
    @SneakyThrows
    @Log("学生-单个课程的学习记录")
    public R learnCourseDetail(
            @PathVariable(name = "id") Integer id,
            @PathVariable(name = "courseId") Integer courseId) {
        return R.success();
    }

    @DeleteMapping("/{id}/learn-course/{courseId}")
    @SneakyThrows
    @Log("学生-线上课学习记录删除")
    public R deleteUserCourse(
            @PathVariable(name = "id") Integer id,
            @PathVariable(name = "courseId") Integer courseId) {
        return R.success();
    }

    @DeleteMapping("/{id}/learn-course/{courseId}/hour/{hourId}")
    @SneakyThrows
    @Log("学员-线上课课时学习记录删除")
    public R destroyUserHour(
            @PathVariable(name = "id") Integer id,
            @PathVariable(name = "courseId") Integer courseId,
            @PathVariable(name = "hourId") Integer hourId) {
        return R.success();
    }
}
    