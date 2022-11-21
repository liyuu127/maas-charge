package com.haylion.charge.user.web;

import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.dto.RoleDetailDto;
import com.haylion.common.entity.dto.RoleDto;
import com.haylion.common.core.validated.Add;
import com.haylion.common.core.validated.Delete;
import com.haylion.common.core.validated.Update;
import com.haylion.common.log.annotation.SysOperateLog;
import com.haylion.charge.user.pojo.form.RoleForm;
import com.haylion.charge.user.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;


    @GetMapping("/list")
    @SysOperateLog(description = "查询角色列表")
    @PreAuthorize("hasAuthority('role:list')")
    public PageInfo<RoleDto> selectList(@RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "code", required = false) String code,
                                        @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return roleService.selectList(name, code, currentPage, pageSize);
    }

    @GetMapping("/info")
    @SysOperateLog(description = "查询角色信息")
    @PreAuthorize("hasAuthority('role:info')")
    public RoleDetailDto info(@RequestParam(value = "id", required = false) Integer id) {
        return roleService.info(id);
    }

    /**
     * 添加角色
     */
    @PostMapping("/insert")
    @PreAuthorize("hasAuthority('role:insert')")
    @SysOperateLog(description = "添加角色信息")
    public void insert(@Validated(Add.class) @RequestBody RoleForm roleForm) {
        roleService.add(roleForm);
    }

    /**
     * 修改角色
     */
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('role:update')")
    @SysOperateLog(description = "修改角色信息")
    public void update(@Validated(Update.class) @RequestBody RoleForm roleForm) {
        roleService.update(roleForm);
    }

    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('role:delete')")
    @SysOperateLog(description = "删除角色信息")
    public void delete(@Validated(Delete.class) @RequestBody RoleForm roleForm) {
        roleService.delete(roleForm);
    }
}
