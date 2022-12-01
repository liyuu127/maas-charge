package com.haylion.charge.system.web;

import com.github.pagehelper.PageInfo;
import com.haylion.charge.system.model.form.DictItemAddForm;
import com.haylion.charge.system.model.form.DictItemDeleteForm;
import com.haylion.charge.system.model.form.DictItemUpdateForm;
import com.haylion.charge.system.service.DictItemService;
import com.haylion.common.entity.entity.DictItemT;
import com.haylion.common.log.annotation.SysOperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2022/4/18 9:50
 */
@RestController
@RequestMapping("/dictItem")
public class DictItemController {
    @Autowired
    private DictItemService dictItemService;
    @PostMapping("/add")
    @SysOperateLog(description = "新增区域节点")
    @PreAuthorize("hasAuthority('dictItem:insert')")
    public DictItemT addDictItem(@RequestBody @Validated DictItemAddForm dictItemAddForm){
       return dictItemService.addDictItem(dictItemAddForm);
    }

    @GetMapping("/listByParent")
    @SysOperateLog(description = "分级查询区域节点列表")
    @PreAuthorize("hasAuthority('dictItem:list')")
    public List<DictItemT> getListByParent(@RequestParam(required = false) Integer parentId){
        return dictItemService.getListByParent(parentId);
    }

    @PostMapping("/update")
    @SysOperateLog(description = "更新区域节点")
    @PreAuthorize("hasAuthority('dictItem:update')")
    public void updateDictItem(@RequestBody @Validated DictItemUpdateForm dictItemUpdateForm){
        dictItemService.updateDictItem(dictItemUpdateForm);
    }

    @PostMapping("/delete")
    @SysOperateLog(description = "删除区域节点")
    @PreAuthorize("hasAuthority('dictItem:delete')")
    public void deleteDictItem(@RequestBody @Validated DictItemDeleteForm dictItemDeleteForm){
        dictItemService.deleteDictItem(dictItemDeleteForm);
    }

    @GetMapping("/list")
    @SysOperateLog(description = "分页查询区域节点列表")
    @PreAuthorize("hasAuthority('dictItem:list')")
    public PageInfo<DictItemT> getList(@RequestParam(required = false,defaultValue = "1")Integer page,
                                      @RequestParam(required = false,defaultValue = "20")Integer size,
                                      @RequestParam(required = false) String name){
        return dictItemService.getList(page,size,name);
    }

}
