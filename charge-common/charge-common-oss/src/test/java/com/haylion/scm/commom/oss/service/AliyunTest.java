package com.haylion.charge.commom.oss.service;

import com.haylion.common.core.model.ResponseData;
import com.haylion.common.oss.OssAutoConfiguration;
import com.haylion.common.oss.model.AliyunUploadParam;
import com.haylion.common.oss.service.OssClient;
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
 * date 2022/4/13 17:00
 * description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OssAutoConfiguration.class)
public class AliyunTest {
    @Autowired
    OssClient aliyunClientImpl;

    @Test
    public void upload_test() throws IOException {
        AliyunUploadParam build = AliyunUploadParam.builder().bucketName("metro-subway-pro")
                .filename("")
                .input(new FileInputStream(new File("C:\\Users\\haylion\\Desktop\\X86CPU的Cache结构图.jpg")))
                .path(null)
                .build();
        ResponseData responseData = aliyunClientImpl.uploadFile(build);
    }
}
