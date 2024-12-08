package cn.edu.nwafu.cie.teach.course.controller;

import cn.edu.nwafu.cie.teach.common.api.R;
import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import cn.edu.nwafu.cie.teach.course.request.CourseUserDeleteRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author Huang Z.Y.
 * @create 2024-12-02 22:03
 */
@RestController
@Slf4j
@RequestMapping("/v1/course/{courseId}/user")
public class CourseUserController {
    @GetMapping("/index")
    @SneakyThrows
    @Log("线上课-学习记录-列表")
    public R index(@PathVariable(name = "courseId") Integer courseId,
                   @RequestParam HashMap<String, Object> params) {
        return R.success();
    }

    @PostMapping("/destroy")
    @Log("线上课-学习记录-删除")
    public R destroy(
            @PathVariable(name = "courseId") Integer courseId,
            @RequestBody @Validated CourseUserDeleteRequest req) {
        return R.success();
    }
}
    