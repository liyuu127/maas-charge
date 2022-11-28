package com.haylion.charge.user.web;

import com.github.pagehelper.PageInfo;
import com.haylion.charge.user.pojo.form.CompanyForm;
import com.haylion.charge.user.pojo.form.MerchantForm;
import com.haylion.charge.user.service.MerchantService;
import com.haylion.common.core.validated.Add;
import com.haylion.common.core.validated.Delete;
import com.haylion.common.core.validated.Update;
import com.haylion.common.entity.entity.ChargeMerchant;
import com.haylion.common.entity.entity.CompanyT;
import com.haylion.common.log.annotation.SysOperateLog;
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
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    MerchantService merchantService;


    @GetMapping("/list")
    @SysOperateLog(description = "查询商户列表")
    @PreAuthorize("hasAuthority('merchant:list')")
    public PageInfo<ChargeMerchant> selectList(@RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "type", required = false) Integer[] type,
                                         @RequestParam(value = "code", required = false) String code,
                                         @RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
                                         @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        return merchantService.selectList(name, type, code, currentPage, pageSize);
    }

    @GetMapping("/info")
    @SysOperateLog(description = "查询商户信息")
    @PreAuthorize("hasAuthority('merchant:info')")
    public ChargeMerchant info(@RequestParam(value = "id", required = true) Integer id) {
        return merchantService.info(id);
    }


    @PostMapping("/insert")
    @SysOperateLog(description = "商户新增")
    @PreAuthorize("hasAuthority('merchant:insert')")
    public void insert(@Validated(Add.class) @RequestBody MerchantForm merchantForm) {
        merchantService.add(merchantForm);
    }


    @PostMapping("/update")
    @SysOperateLog(description = "商户更新")
    @PreAuthorize("hasAuthority('merchant:update')")
    public void update(@Validated(Update.class) @RequestBody MerchantForm merchantForm) {
        merchantService.update(merchantForm);
    }

    @PostMapping("/delete")
    @SysOperateLog(description = "商户删除")
    @PreAuthorize("hasAuthority('merchant:delete')")
    public void delete(@Validated(Delete.class) @RequestBody MerchantForm merchantForm) {
        merchantService.delete(merchantForm);
    }
}
