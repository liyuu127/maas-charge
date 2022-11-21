package com.haylion.charge.system.web;

import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.entity.AppInfo;
import com.haylion.common.core.constant.CommonConstant;
import com.haylion.common.core.model.ResponseData;
import com.haylion.charge.system.model.form.AppInfoForm;
import com.haylion.charge.system.service.AppInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Laixiaopeng
 * @date 2021/02/20 10:45
 * @description
 **/
@RestController
@RequestMapping("/appInfo")
@Slf4j
public class AppInfoController {
    @Autowired
    private AppInfoService appInfoService;

    @PostMapping("add")
    public void addAppInfo(@RequestBody AppInfoForm appInfoForm) {
        appInfoService.addAppInfo(appInfoForm);
    }

    @PostMapping("/upload")
    public ResponseData upload(MultipartFile file, Integer terminal) throws IOException {
         return appInfoService.uploadApp(file, terminal);
    }

    @PostMapping("edit")
    public void editAppInfo(@RequestBody AppInfoForm appInfoForm) {
        AppInfo appInfo = new AppInfo();
        BeanUtils.copyProperties(appInfoForm, appInfo);
        appInfoService.editAppInfo(appInfo);
    }

    @PostMapping("release")
    public void releaseApp(@RequestBody AppInfoForm appInfoForm) {
        appInfoService.releaseApp(appInfoForm.getId());
    }

    @PostMapping("delete")
    public void deleteAppInfo(@RequestBody AppInfoForm appInfoForm) {
        AppInfo appInfo = new AppInfo();
        BeanUtils.copyProperties(appInfoForm, appInfo);
        appInfo.setDeleted(CommonConstant.DELETED_YES);
        appInfoService.editAppInfo(appInfo);
    }

    @GetMapping("list")
    public PageInfo<AppInfo> getAppInfoList(@RequestParam(required = false, defaultValue = "1") Integer page,
                                            @RequestParam(required = false, defaultValue = "20") Integer size,
                                            @RequestParam(required = false) Byte type,
                                            @RequestParam(required = false) Integer versionNumber,
                                            @RequestParam(required = false) String versionName) {
        return new PageInfo<>(appInfoService.getAppInfoList(page, size, type, versionNumber, versionName));
    }

    @GetMapping("latest")
    public AppInfo getLatestVersionAppInfo(@RequestParam(required = false, defaultValue = "1") Byte appType) {
        return appInfoService.getLatestVersionAppInfo(appType);
    }
}
