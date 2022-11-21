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
public class UploadServiceTest {

    @Autowired
    OssClient aliyunClientImpl;
    @Autowired
    UploadService uploadService;

    @Test
    public void upload_test() throws IOException {
        AliyunUploadParam build = AliyunUploadParam.builder().bucketName("metro-subway-pro")
                .filename("X86CPU的Cache结构图.jpg")
                .input(new FileInputStream(new File("C:\\Users\\haylion\\Desktop\\X86CPU的Cache结构图.jpg")))
                .path(null)
                .build();
        ResponseData responseData = aliyunClientImpl.uploadFile(build);
    }

    @Test
    public void delete_test() throws IOException {
        uploadService.delete("http://metro-subway-pro.oss-cn-shenzhen.aliyuncs.com/file/2022/04/14/1649901753429-X86CPU%E7%9A%84Cache%E7%BB%93%E6%9E%84%E5%9B%BE.jpg");
    }
}
