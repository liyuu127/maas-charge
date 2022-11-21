package com.haylion.charge.user.web;

import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.dto.ResourceDto;
import com.haylion.common.auth.util.SecurityUtil;
import com.haylion.common.log.annotation.SysOperateLog;
import com.haylion.charge.user.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liyu
 * date 2022/4/7 15:06
 * description
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    ResourceService resourceService;


    @GetMapping("/list")
    @SysOperateLog(description = "查询资源列表")
    @PreAuthorize("hasAuthority('resource:list')")
    public PageInfo<ResourceDto> selectList(@RequestParam(value = "name", required = false) String name,
                                            @RequestParam(value = "pId", required = false) Integer pId,
                                            @RequestParam(value = "status", required = false) Integer status,
                                            @RequestParam(value = "group", required = false) String group,
                                            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return resourceService.selectList(SecurityUtil.getUser().getUserId(), name, pId, status, group, currentPage, pageSize);
    }

    @GetMapping("/all")
    @SysOperateLog(description = "查询资源列表")
    @PreAuthorize("hasAuthority('resource:list')")
    public List<ResourceDto> selectAll() {
        return resourceService.selectAll();
    }

}
