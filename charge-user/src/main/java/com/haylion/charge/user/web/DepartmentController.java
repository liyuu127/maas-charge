package com.haylion.charge.user.web;

import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.entity.DepartmentT;
import com.haylion.common.core.validated.Add;
import com.haylion.common.core.validated.Delete;
import com.haylion.common.core.validated.Update;
import com.haylion.common.log.annotation.SysOperateLog;
import com.haylion.charge.user.pojo.form.DepartmentForm;
import com.haylion.charge.user.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author liyu
 * date 2022/4/7 15:06
 * description
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;


    @GetMapping("/list")
    @SysOperateLog(description = "查询部门列表")
    @PreAuthorize("hasAuthority('department:list')")
    public PageInfo<DepartmentT> selectList(@RequestParam(value = "name", required = false) String name,
                                            @RequestParam(value = "cId", required = false) Integer cId,
                                            @RequestParam(value = "resName", required = false) String resName,
                                            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return departmentService.selectList(name, cId, resName, currentPage, pageSize);
    }

    @GetMapping("/info")
    @SysOperateLog(description = "查询部门信息")
    @PreAuthorize("hasAuthority('department:info')")
    public DepartmentT info(@RequestParam(value = "id", required = true) Integer id) {
        return departmentService.info(id);
    }


    @PostMapping("/insert")
    @SysOperateLog(description = "部门新增")
    @PreAuthorize("hasAuthority('department:insert')")
    public void insert(@Validated(Add.class) @RequestBody DepartmentForm departmentForm) {
        departmentService.add(departmentForm);
    }


    @PostMapping("/update")
    @SysOperateLog(description = "部门更新")
    @PreAuthorize("hasAuthority('department:update')")
    public void update(@Validated(Update.class) @RequestBody DepartmentForm departmentForm) {
        departmentService.update(departmentForm);
    }

    @PostMapping("/delete")
    @SysOperateLog(description = "部门删除")
    @PreAuthorize("hasAuthority('department:delete')")
    public void delete(@Validated(Delete.class) @RequestBody DepartmentForm departmentForm) {
        departmentService.delete(departmentForm);
    }
}
