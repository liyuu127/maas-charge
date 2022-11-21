package com.haylion.common.oss.model;

/**
 * @author liyu
 * date 2022/4/13 16:16
 * description
 */
public class DeleteParam {
    /**
     * 非必填 存储路径 a/b/c.jpg
     */
    private String path;

    public String getPath() {
        return path;
    }


    DeleteParam(String path) {
        this.path = path;
    }
}
