package com.haylion.charge.user.web;

import com.github.pagehelper.PageInfo;
import com.haylion.common.core.validated.Add;
import com.haylion.common.core.validated.Delete;
import com.haylion.common.core.validated.Update;
import com.haylion.common.entity.dto.PositionDto;
import com.haylion.common.entity.dto.PositionInfoDto;
import com.haylion.common.log.annotation.SysOperateLog;
import com.haylion.charge.user.pojo.form.PositionForm;
import com.haylion.charge.user.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liyu
 * date 2022/4/7 15:06
 * description
 */
@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    PositionService positionService;


    @GetMapping("/list")
    @SysOperateLog(description = "查询职位列表")
    @PreAuthorize("hasAuthority('position:list')")
    public PageInfo<PositionDto> selectList(@RequestParam(value = "name", required = false) String name,
                                            @RequestParam(value = "cId", required = false) Integer cId,
                                            @RequestParam(value = "dId", required = false) Integer dId,
                                            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return positionService.selectList(name, cId, dId, currentPage, pageSize);
    }

    @GetMapping("/list/all")
    @SysOperateLog(description = "查询职位列表")
    @PreAuthorize("hasAuthority('position:list')")
    public List<PositionDto> listAll(@RequestParam(value = "name", required = false) String name,
                                     @RequestParam(value = "dId", required = false) Integer dId) {
        return positionService.listAll(name, dId);
    }

    @GetMapping("/info")
    @SysOperateLog(description = "查询职位信息")
    @PreAuthorize("hasAuthority('position:info')")
    public PositionInfoDto info(@RequestParam(value = "id", required = true) Integer id) {
        return positionService.info(id);
    }


    @PostMapping("/insert")
    @SysOperateLog(description = "职位添加")
    @PreAuthorize("hasAuthority('position:insert')")
    public void insert(@Validated(Add.class) @RequestBody PositionForm positionForm) {
        positionService.add(positionForm);
    }


    @PostMapping("/update")
    @SysOperateLog(description = "职位修改")
    @PreAuthorize("hasAuthority('position:update')")
    public void update(@Validated(Update.class) @RequestBody PositionForm positionForm) {
        positionService.update(positionForm);
    }

    @PostMapping("/delete")
    @SysOperateLog(description = "职位删除")
    @PreAuthorize("hasAuthority('position:delete')")
    public void delete(@Validated(Delete.class) @RequestBody PositionForm positionForm) {
        positionService.delete(positionForm);
    }
}
