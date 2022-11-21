package com.haylion.charge.system.service;


import com.github.pagehelper.PageHelper;
import com.haylion.common.entity.entity.AppInfo;
import com.haylion.common.core.constant.CommonConstant;
import com.haylion.common.core.model.ResponseData;
import com.haylion.common.repository.mapper.AppInfoMapper;
import com.haylion.charge.system.model.form.AppInfoForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static com.haylion.charge.system.constant.SystemConstant.TERMINAL_TYPE_MAINTENANCE;
import static com.haylion.charge.system.constant.SystemConstant.TERMINAL_TYPE_USER;

/**
 * @author Laixiaopeng
 * @date 2021/02/20 10:45
 * @description
 **/
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
@RefreshScope
public class AppInfoService {
    @Autowired
    private AppInfoMapper appInfoMapper;
    @Autowired
    private UploadService uploadService;
    @Value("${charge.oss.user-app-path}")
    private String userAppPath;
    @Value("${charge.oss.maintenance-app-path}")
    private String maintenanceAppPath;

    public void addAppInfo(AppInfoForm appInfoForm) {
        AppInfo appInfo = new AppInfo();
        BeanUtils.copyProperties(appInfoForm, appInfo);
        LocalDateTime now = LocalDateTime.now();
        appInfo.setCreatedAt(now)
                .setUpdatedAt(now)
                .setValid(CommonConstant.VALID_NO);
        appInfoMapper.insertSelective(appInfo);
    }

    public ResponseData uploadApp(MultipartFile file, Integer terminal) throws IOException {
        String path = "";
        if (TERMINAL_TYPE_USER == terminal) {
            path = userAppPath;
        } else if (TERMINAL_TYPE_MAINTENANCE == terminal) {
            path = maintenanceAppPath;
        }
        return uploadService.upload(file, path);
    }

    public List<AppInfo> getAppInfoList(Integer page, Integer size, Byte type, Integer versionNumber, String versionName) {
        PageHelper.startPage(page, size);
        return appInfoMapper.selectAppInfoList(type, versionNumber, versionName);
    }

    public void editAppInfo(AppInfo appInfo) {
        appInfo.setUpdatedAt(LocalDateTime.now());
        appInfoMapper.insertOrUpdateSelective(appInfo);
    }

    public void releaseApp(Integer id) {
        appInfoMapper.validCurrent(id);
        AppInfo appInfo = appInfoMapper.selectById(id);
        appInfoMapper.invalidOld(id, appInfo.getAppType());
    }

    public AppInfo getLatestVersionAppInfo(Byte appType) {
        return appInfoMapper.selectLatestVersionAppInfo(appType);
    }
}
