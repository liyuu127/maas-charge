package com.haylion.charge.system.web;

import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.entity.LookupParentT;
import com.haylion.charge.system.model.form.LookupParentForm;
import com.haylion.charge.system.service.LookupParentTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author hqf
 * @Date 2021/10/29
 */
@RestController
@RequestMapping("/lookupParent")
public class LookupParentTController {

    @Autowired
    LookupParentTService lookupParentTService;

    @PostMapping("/add")
    public void addLookupParent(@RequestBody LookupParentForm lookupParentForm) {

        lookupParentTService.addLookupParent(lookupParentForm);
    }

    @PostMapping("/update")
    public void updateLookupParent(@RequestBody LookupParentForm lookupParentForm) {

        lookupParentTService.updateLookupParent(lookupParentForm);
    }

    @GetMapping("/list")
    public PageInfo listLookupParent(@RequestParam(required = false) String value,
                                     @RequestParam(required = false) String name,
                                     @RequestParam(required = false, defaultValue = "1") Integer page,
                                     @RequestParam(required = false, defaultValue = "20") Integer size) {

        return lookupParentTService.listLookupParent(value, name, page, size);
    }

    @RequestMapping("/delete/{id}")
    public void deleteLookupParent(@PathVariable Integer id) {
        lookupParentTService.deleteLookupParent(id);
    }

    /**
     * @param value
     * @return com.yelink.metro.common.data.entity.LookupParentT
     * @Description 根据value获取详情
     * @Author hqf
     * @Date 2021/12/6
     **/
    @RequestMapping("/info")
    public LookupParentT getInfo(@RequestParam String value) {

        return lookupParentTService.getInfo(value);
    }
}
