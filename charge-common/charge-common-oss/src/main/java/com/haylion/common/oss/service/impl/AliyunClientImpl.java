package com.haylion.common.oss.service.impl;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.haylion.common.core.model.ResponseData;
import com.haylion.common.oss.model.AliyunDeleteParam;
import com.haylion.common.oss.model.AliyunUploadParam;
import com.haylion.common.oss.model.DeleteParam;
import com.haylion.common.oss.model.UploadParam;
import com.haylion.common.oss.service.OssClient;
import com.haylion.common.oss.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;

/**
 * @author liyu
 * date 2021/6/8 18:40
 * description
 */
@Slf4j
@Component
public class AliyunClientImpl implements OssClient {
    @Autowired
    OSS ossClient;

    @Override
    public ResponseData uploadFile(UploadParam uploadParam) {
        if (uploadParam == null) return null;
        AliyunUploadParam aliyunUploadParam = (AliyunUploadParam) uploadParam;
        String bucketName = aliyunUploadParam.getBucketName();
        String filePath = StringUtils.isBlank(aliyunUploadParam.getPath()) ? FileUtils.getFilePath(aliyunUploadParam.getFilename()) : aliyunUploadParam.getPath();
        ossClient.putObject(bucketName, filePath, uploadParam.getInput());
        String url = getUrl(bucketName, filePath);
        return ResponseData.success(url);
    }

    private String getUrl(String bucketName, String filePath) {
        OSSClient client = (OSSClient) this.ossClient;
        URI endpoint = client.getEndpoint();
        return endpoint.getScheme() + "://" + bucketName + "." + endpoint.getHost() + "/" + filePath;
    }

    @Override
    public ResponseData deleteFile(DeleteParam deleteParam) {
        OSSClient client = (OSSClient) this.ossClient;
        String host = client.getEndpoint().getHost();
        AliyunDeleteParam aliyunDeleteParam = (AliyunDeleteParam) deleteParam;
        String path = aliyunDeleteParam.getPath();
        if (path.startsWith("http") || path.startsWith("https")) {
            if (path.contains(host)) {
                path = path.substring(path.lastIndexOf(host) + host.length() + 1);
            }
        }
        ossClient.deleteObject(aliyunDeleteParam.getBucketName(), path);
        return ResponseData.success();
    }

}
