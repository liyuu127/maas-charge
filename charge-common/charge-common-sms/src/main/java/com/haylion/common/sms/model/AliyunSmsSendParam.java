package com.haylion.common.sms.model;


/**
 * @author liyu
 * date 2022/4/13 13:56
 * description 入参列表 https://help.aliyun.com/document_detail/55284.html?spm=a2c4g.11186623.6.568.715e4f30ZiVkbI
 */

public class AliyunSmsSendParam {
    /**
     * 可选:模板中的变量替换JSON串,如模板内容为"【企业级分布式应用服务】,您的验证码为${code}"时,此处的值为
     */
    private String code;
    /**
     * 必填:短信模板-可在短信控制台中找到
     */
    private String templateCode;
    /**
     * 必填:短信签名-可在短信控制台中找到
     */
    private String signName;
    /**
     * 必填:待发送手机号
     */
    private String phoneNumbers;

    public String getCode() {
        return code;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public String getSignName() {
        return signName;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    private AliyunSmsSendParam(String code, String templateCode, String signName, String phoneNumbers) {
        this.code = code;
        this.templateCode = templateCode;
        this.signName = signName;
        this.phoneNumbers = phoneNumbers;
    }

    public static AliyunSmsSendParam.AliyunSmsSendParamBuilder builder() {
        return new AliyunSmsSendParam.AliyunSmsSendParamBuilder();
    }

    public static class AliyunSmsSendParamBuilder {
        private String code;
        private String templateCode;
        private String signName;
        private String phoneNumbers;

        AliyunSmsSendParamBuilder() {
        }


        public AliyunSmsSendParam.AliyunSmsSendParamBuilder code(String code) {
            this.code = code;
            return this;
        }

        public AliyunSmsSendParam.AliyunSmsSendParamBuilder templateCode(String templateCode) {
            if (templateCode == null || templateCode.equals("")) {
                throw new IllegalArgumentException("templateCode can not be null");
            }
            this.templateCode = templateCode;
            return this;
        }

        public AliyunSmsSendParam.AliyunSmsSendParamBuilder signName(String signName) {
            if (signName == null || signName.equals("")) {
                throw new IllegalArgumentException("signName can not be null");
            }
            this.signName = signName;
            return this;
        }

        public AliyunSmsSendParam.AliyunSmsSendParamBuilder phoneNumbers(String phoneNumbers) {
            if (phoneNumbers == null || phoneNumbers.equals("")) {
                throw new IllegalArgumentException("phoneNumbers can not be null");
            }
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public AliyunSmsSendParam build() {
            if (this.templateCode == null) throw new IllegalArgumentException("templateCode can not be null");
            if (this.signName == null) throw new IllegalArgumentException("signName can not be null");
            if (this.phoneNumbers == null) throw new IllegalArgumentException("phoneNumbers can not be null");
            return new AliyunSmsSendParam(this.code, this.templateCode, this.signName, this.phoneNumbers);
        }

        public String toString() {
            return "AliyunSmsSendParam.AliyunSmsSendParamBuilder(code=" + this.code + ", templateCode=" + this.templateCode + ", signName=" + this.signName + ", phoneNumbers=" + this.phoneNumbers + ")";
        }
    }
}
