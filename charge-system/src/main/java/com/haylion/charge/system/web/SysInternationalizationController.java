package com.haylion.charge.system.web;

import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.entity.SysInternationalization;
import com.haylion.common.log.annotation.SysOperateLog;
import com.haylion.charge.system.model.form.SysInternationalizationAddForm;
import com.haylion.charge.system.model.form.SysInternationalizationDeleteForm;
import com.haylion.charge.system.model.form.SysInternationalizationEditForm;
import com.haylion.charge.system.service.SysInternationalizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**@author Laixiaopeng
 * date 2022/4/15 22:00:01
 * description 国际化
 */
@Slf4j
@RestController
@RequestMapping("/internationalization")
public class SysInternationalizationController {

    @Autowired
    private SysInternationalizationService sysInternationalizationService;

    @GetMapping("/findAll")
    @SysOperateLog(description = "查询可用国际化配置数据")
    public List<SysInternationalization> selectInternationalization(){
        return sysInternationalizationService.selectInternationalization();
    }

    @GetMapping("list")
    @SysOperateLog(description = "分页查询国际化列表")
    @PreAuthorize("hasAuthority('internationalization:list')")
    public PageInfo<SysInternationalization> getList(@RequestParam(required = false)String code,
                                                     @RequestParam(required = false)String value,
                                                     @RequestParam(required = false,defaultValue = "1")Integer page,
                                                     @RequestParam(required = false,defaultValue = "20")Integer size){
        return sysInternationalizationService.getList(page,size,code,value);
    }

    @PostMapping("add")
    @SysOperateLog(description = "新增国际化配置")
    @PreAuthorize("hasAuthority('internationalization:insert')")
    public void addSysInternationalization(@RequestBody @Validated SysInternationalizationAddForm sysInternationalizationAddForm){
        sysInternationalizationService.addSysInternationalization(sysInternationalizationAddForm);
    }
    @PostMapping("edit")
    @SysOperateLog(description = "编辑国际化配置")
    @PreAuthorize("hasAuthority('internationalization:audit')")
    public void editSysInternationalization(@RequestBody @Validated SysInternationalizationEditForm sysInternationalizationEditForm){
        sysInternationalizationService.editSysInternationalization(sysInternationalizationEditForm);
    }

    @PostMapping("delete")
    @SysOperateLog(description = "删除国际化配置")
    @PreAuthorize("hasAuthority('internationalization:delete')")
    public void deleteSysInternationalization(@RequestBody @Validated SysInternationalizationDeleteForm sysInternationalizationDeleteForm){
        sysInternationalizationService.deleteSysInternationalization(sysInternationalizationDeleteForm);
    }
}
