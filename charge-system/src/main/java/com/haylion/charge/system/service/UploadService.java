package com.haylion.charge.system.service;


import com.haylion.common.core.model.ResponseData;
import com.haylion.common.oss.model.AliyunDeleteParam;
import com.haylion.common.oss.model.AliyunUploadParam;
import com.haylion.common.oss.service.OssClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @description: 上传接口
 * @author: zengfu
 * @create: 2020-06-11 11:36
 **/
@Slf4j
@Service
public class UploadService {

    @Autowired
    OssClient aliyunClientImpl;
    @Value("${mc.oss.bucketName}")
    String bucketName;


    /**
     * 上传文件
     *
     * @param file
     * @return
     * @throws Exception
     */
    public ResponseData upload(MultipartFile file, String path) throws IOException {
        AliyunUploadParam uploadParam = AliyunUploadParam.builder()
                .filename(file.getOriginalFilename())
                .path(path)
                .input(new ByteArrayInputStream(file.getBytes()))
                .bucketName(bucketName)
                .build();
        return aliyunClientImpl.uploadFile(uploadParam);
    }

    public ResponseData upload(MultipartFile file) throws IOException {
        return upload(file, null);
    }

    /**
     * 根据文件路径删除文件
     *
     * @param fileUrl
     * @return
     */
    public ResponseData delete(String fileUrl) {
        AliyunDeleteParam deleteParam = AliyunDeleteParam.builder()
                .path(fileUrl)
                .bucketName(bucketName)
                .build();
        return aliyunClientImpl.deleteFile(deleteParam);
    }

}
