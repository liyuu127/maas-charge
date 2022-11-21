package com.haylion.charge.system.web;

import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.entity.LookupChildT;
import com.haylion.charge.system.model.form.LookupChildForm;
import com.haylion.charge.system.service.LookupChildTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author hqf
 * @Date 2021/10/29
 */
@RestController
@RequestMapping("/lookupChild")
public class LookupChildTController {

    @Autowired
    LookupChildTService lookupChildTService;

    @PostMapping("/add")
    public void addLookupChild(@RequestBody LookupChildForm lookupChildForm) {
        lookupChildTService.addLookupChild(lookupChildForm);
    }

    @PostMapping("/update")
    public void updateLookupChild(@RequestBody LookupChildForm lookupChildForm) {
        lookupChildTService.updateLookupChild(lookupChildForm);
    }

    @RequestMapping("/delete/{id}")
    public void deleteLookupChild(@PathVariable Integer id) {
        lookupChildTService.deleteLookupChild(id);
    }

    @GetMapping("/list")
    public PageInfo<LookupChildT> listLookupChildByPid(@RequestParam Integer pid,
                                                       @RequestParam(required = false, defaultValue = "1") Integer page,
                                                       @RequestParam(required = false, defaultValue = "20") Integer size) {
        return lookupChildTService.listLookupChildByPid(pid, page, size);
    }

    @GetMapping("/listByPvalue")
    public List<LookupChildT> listLookupChildByPValue(@RequestParam String value) {

        return lookupChildTService.listLookupChildByPValue(value);
    }
}
