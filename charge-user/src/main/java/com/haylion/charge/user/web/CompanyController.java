package com.haylion.charge.user.web;

import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.entity.CompanyT;
import com.haylion.common.core.validated.Add;
import com.haylion.common.core.validated.Delete;
import com.haylion.common.core.validated.Update;
import com.haylion.common.log.annotation.SysOperateLog;
import com.haylion.charge.user.pojo.form.CompanyForm;
import com.haylion.charge.user.service.CompanyService;
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
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;


    @GetMapping("/list")
    @SysOperateLog(description = "查询公司列表")
    @PreAuthorize("hasAuthority('company:list')")
    public PageInfo<CompanyT> selectList(@RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "type", required = false) Integer[] type,
                                         @RequestParam(value = "resName", required = false) String resName,
                                         @RequestParam(value = "supplierCode", required = false) String supplierCode,
                                         @RequestParam(value = "innerCompany", required = false) Integer innerCompany,
                                         @RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
                                         @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        return companyService.selectList(name, type, resName, supplierCode, innerCompany, currentPage, pageSize);
    }

    @GetMapping("/info")
    @SysOperateLog(description = "查询公司信息")
    @PreAuthorize("hasAuthority('company:info')")
    public CompanyT info(@RequestParam(value = "id", required = true) Integer id) {
        return companyService.info(id);
    }


    @PostMapping("/insert")
    @SysOperateLog(description = "公司新增")
    @PreAuthorize("hasAuthority('company:insert')")
    public void insert(@Validated(Add.class) @RequestBody CompanyForm companyForm) {
        companyService.add(companyForm);
    }


    @PostMapping("/update")
    @SysOperateLog(description = "公司更新")
    @PreAuthorize("hasAuthority('company:update')")
    public void update(@Validated(Update.class) @RequestBody CompanyForm companyForm) {
        companyService.update(companyForm);
    }

    @PostMapping("/delete")
    @SysOperateLog(description = "公司删除")
    @PreAuthorize("hasAuthority('company:delete')")
    public void delete(@Validated(Delete.class) @RequestBody CompanyForm companyForm) {
        companyService.delete(companyForm);
    }
}
