package com.haylion.common.oss.model;

import java.io.InputStream;

/**
 * @author liyu
 * date 2022/4/13 16:17
 * description
 */
public class AliyunUploadParam extends UploadParam {
    /**
     * 必填
     */
    private String bucketName;

    public String getBucketName() {
        return this.bucketName;
    }

    private AliyunUploadParam(String path, String filename, InputStream input, String bucketName) {
        super(path, filename, input);
        this.bucketName = bucketName;
    }

    public static AliyunUploadParam.AliyunUploadParamBuilder builder() {
        return new AliyunUploadParam.AliyunUploadParamBuilder();
    }

    public static class AliyunUploadParamBuilder {
        private String path;
        private String filename;
        private InputStream input;
        private String bucketName;

        AliyunUploadParamBuilder() {
        }

        public AliyunUploadParam.AliyunUploadParamBuilder path(String path) {
            this.path = path;
            return this;
        }

        public AliyunUploadParam.AliyunUploadParamBuilder filename(String filename) {
            this.filename = filename;
            return this;
        }

        public AliyunUploadParam.AliyunUploadParamBuilder input(InputStream input) {
            this.input = input;
            return this;
        }

        public AliyunUploadParam.AliyunUploadParamBuilder bucketName(String bucketName) {
            this.bucketName = bucketName;
            return this;
        }

        public AliyunUploadParam build() {
            if (this.bucketName == null || this.bucketName.equals(""))
                throw new IllegalArgumentException("bucketName can not be null");

            if (this.filename == null || this.filename.equals(""))
                throw new IllegalArgumentException("filename can not be null");

            if (this.input == null)
                throw new IllegalArgumentException("input can not be null");

            return new AliyunUploadParam(this.path, this.filename, this.input, this.bucketName);
        }

        public String toString() {
            return "AliyunUploadParam.AliyunUploadParamBuilder(path=" + this.path + ", filename=" + this.filename + ", input=" + this.input + ", bucketName=" + this.bucketName + ")";
        }
    }
}
