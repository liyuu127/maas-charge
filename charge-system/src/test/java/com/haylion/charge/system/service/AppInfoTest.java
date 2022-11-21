package com.haylion.charge.system.service;

import com.haylion.common.core.model.ResponseData;
import com.haylion.common.oss.model.AliyunUploadParam;
import com.haylion.common.oss.service.OssClient;
import com.haylion.charge.system.ScmSystemApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author liyu
 * date 2022/4/13 17:19
 * description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScmSystemApplication.class)
public class AppInfoTest {

    @Autowired
    AppInfoService appInfoService;
    @Autowired
    UploadService uploadService;
    @Autowired
    OssClient aliyunClientImpl;

    @Test
    public void upload_test() throws IOException {
        String path = "app/dev/charge.apk";
        AliyunUploadParam uploadParam = AliyunUploadParam.builder()
                .path(path)
                .filename("name")
                .input(new FileInputStream(new File("C:\\Users\\haylion\\Desktop\\download.png")))
                .bucketName("health-charge-pro")
                .build();
        ResponseData responseData = aliyunClientImpl.uploadFile(uploadParam);

    }

}
