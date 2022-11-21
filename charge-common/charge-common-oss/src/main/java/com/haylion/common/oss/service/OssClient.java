package com.haylion.common.oss.service;


import com.haylion.common.core.model.ResponseData;
import com.haylion.common.oss.model.DeleteParam;
import com.haylion.common.oss.model.UploadParam;

import java.io.IOException;


public interface OssClient {
    /**
     * 上传文件
     *
     * @return
     * @throws IOException
     */
    ResponseData uploadFile(UploadParam uploadParam);

    /**
     * 根据http url删除文件
     *
     * @return
     * @throws IOException
     */
    ResponseData deleteFile(DeleteParam deleteParam);

}
