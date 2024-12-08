package cn.edu.nwafu.cie.teach.resource.resource;

import cn.edu.nwafu.cie.teach.common.api.R;
import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import cn.edu.nwafu.cie.teach.resource.request.ResourceDeleteBatchRequest;
import cn.edu.nwafu.cie.teach.resource.request.ResourceUpdateRequest;
import lombok.SneakyThrows;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author Huang Z.Y.
 * @create 2024-12-07 21:33
 */
@RestController
@RequestMapping("/v1/resource")
public class ResourceController {
    @GetMapping("/index")
    @Log("资源-列表")
    public R index(@RequestParam HashMap<String, Object> params) {
        return R.success();
    }

    @DeleteMapping("/{id}")
    @Transactional
    @SneakyThrows
    @Log("资源-删除")
    public R destroy(@PathVariable(name = "id") Integer id) {
        return R.success();
    }

    @PostMapping("/destroy-batch")
    @SneakyThrows
    @Log("资源-批量列表")
    public R deleteBatch(@RequestBody ResourceDeleteBatchRequest req) {
        return R.success();
    }

    @PutMapping("/{id}")
    @SneakyThrows
    @Log("资源-编辑")
    public R update(@RequestBody @Validated ResourceUpdateRequest req,
                    @PathVariable(name = "id") Integer id) {
        return R.success();
    }
}
    