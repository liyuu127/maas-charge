package com.haylion.common.oss.model;

import java.io.InputStream;

/**
 * @author liyu
 * date 2022/4/13 16:16
 * description
 */

public class UploadParam {
    /**
     * 非必填 存储路径 a/b/c.jpg
     */
    private String path;
    /**
     * 必填 文件名 xx.jpg
     */
    private String filename;
    /**
     * 必填 源文件
     */
    private InputStream input;

    public String getPath() {
        return path;
    }

    public String getFilename() {
        return filename;
    }

    public InputStream getInput() {
        return input;
    }

    UploadParam(String path, String filename, InputStream input) {
        this.path = path;
        this.filename = filename;
        this.input = input;
    }
}
