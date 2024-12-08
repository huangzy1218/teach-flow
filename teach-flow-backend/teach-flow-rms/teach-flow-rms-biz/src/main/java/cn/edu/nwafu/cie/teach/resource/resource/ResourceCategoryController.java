package cn.edu.nwafu.cie.teach.resource.resource;

import cn.edu.nwafu.cie.teach.common.api.R;
import cn.edu.nwafu.cie.teach.common.exception.NotFoundException;
import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import cn.edu.nwafu.cie.teach.resource.request.ResourceCategoryParentRequest;
import cn.edu.nwafu.cie.teach.resource.request.ResourceCategoryRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Huang Z.Y.
 * @create 2024-12-07 21:19
 */
@RestController
@RequestMapping("/v1/resource-category")
public class ResourceCategoryController {
    @GetMapping("/index")
    @Log("资源-分类-列表")
    public R list() {
        return R.success();
    }

    @GetMapping("/categories")
    @Log("资源-分类-全部分类")
    public R index(@RequestParam(name = "parent_id", defaultValue = "0") Integer parentId) {
        return R.success();
    }

    @PostMapping("/create")
    @Log("资源-分类-新建")
    public R create(@RequestBody @Validated ResourceCategoryRequest req) {
        return R.success();
    }

    @PutMapping("/{id}")
    @Log("资源-分类-编辑")
    public R update(@PathVariable Integer id, @RequestBody ResourceCategoryRequest req)
            throws NotFoundException {
        return R.success();
    }

    @DeleteMapping("/{id}")
    @Log("资源-分类-删除")
    public R delete(@PathVariable Integer id) {
        return R.success();
    }

    @PutMapping("/update/parent")
    @Log("资源-分类-更新父级")
    public R updateParent(@RequestBody @Validated ResourceCategoryParentRequest req) {
        return R.success();
    }
}
    