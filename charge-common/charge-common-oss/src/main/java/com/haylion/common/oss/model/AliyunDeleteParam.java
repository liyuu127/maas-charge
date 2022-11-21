package com.haylion.common.oss.model;

/**
 * @author liyu
 * date 2022/4/14 10:22
 * description
 */
public class AliyunDeleteParam extends DeleteParam {
    /**
     * 必填
     */
    private String bucketName;

    public String getBucketName() {
        return this.bucketName;
    }

    private AliyunDeleteParam(String path, String bucketName) {
        super(path);
        this.bucketName = bucketName;
    }

    public static AliyunDeleteParam.AliyunDeleteParamBuilder builder() {
        return new AliyunDeleteParam.AliyunDeleteParamBuilder();
    }

    public static class AliyunDeleteParamBuilder {
        private String path;
        private String bucketName;

        AliyunDeleteParamBuilder() {
        }

        public AliyunDeleteParam.AliyunDeleteParamBuilder path(String path) {
            this.path = path;
            return this;
        }

        public AliyunDeleteParam.AliyunDeleteParamBuilder bucketName(String bucketName) {
            this.bucketName = bucketName;
            return this;
        }

        public AliyunDeleteParam build() {
            if (this.bucketName == null || this.bucketName.equals(""))
                throw new IllegalArgumentException("bucketName can not be null");

            if (this.path == null || this.path.equals(""))
                throw new IllegalArgumentException("path can not be null");
            return new AliyunDeleteParam(this.path, this.bucketName);
        }

        public String toString() {
            return "AliyunDeleteParam.AliyunDeleteParamBuilder(path=" + this.path + ", bucketName=" + this.bucketName + ")";
        }
    }
}
