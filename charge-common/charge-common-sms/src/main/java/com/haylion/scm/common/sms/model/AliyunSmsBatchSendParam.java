package com.haylion.charge.common.sms.model;


import com.alibaba.fastjson.JSON;

import java.util.Collection;

/**
 * @author liyu
 * date 2022/4/13 13:56
 * description 入参列表 https://help.aliyun.com/document_detail/55284.html?spm=a2c4g.11186623.6.568.715e4f30ZiVkbI
 */

public class AliyunSmsBatchSendParam {
    /**
     * 可选:模板中的变量替换JSON串,如模板内容为"【企业级分布式应用服务】,您的验证码为${code}"时,此处的值为
     */
    private String codeJson;
    /**
     * 必填:短信模板-可在短信控制台中找到
     */
    private String templateCode;
    /**
     * 必填:短信签名-支持不同的号码发送不同的短信签名
     */
    private String signName;
    /**
     * 必填:待发送手机号。支持JSON格式的批量调用，批量上限为100个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
     */
    private String phoneNumbers;

    public String getCodeJson() {
        return codeJson;
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

    @Override
    public String toString() {
        return "AliyunSmsBatchSendParam{" +
                "codeJson='" + codeJson + '\'' +
                ", templateCode='" + templateCode + '\'' +
                ", signName='" + signName + '\'' +
                ", phoneNumbers='" + phoneNumbers + '\'' +
                '}';
    }

    private AliyunSmsBatchSendParam(String codeJson, String templateCode, String signName, String phoneNumbers) {
        this.codeJson = codeJson;
        this.templateCode = templateCode;
        this.signName = signName;
        this.phoneNumbers = phoneNumbers;
    }

    public static AliyunSmsBatchSendParam.AliyunSmsSendParamBuilder builder() {
        return new AliyunSmsBatchSendParam.AliyunSmsSendParamBuilder();
    }

    public static class AliyunSmsSendParamBuilder {
        private String codeJson;
        private String templateCode;
        private String signName;
        private String phoneNumbers;

        AliyunSmsSendParamBuilder() {
        }

        /**
         * json 格式 需要转义符 [{\"name\":\"" + name + "\"},{\"code\":\"" + code + "\"}]
         *
         * @param codeJson
         * @return
         */
        public AliyunSmsBatchSendParam.AliyunSmsSendParamBuilder codeJson(String codeJson) {
            this.codeJson = codeJson;
            return this;
        }

        public AliyunSmsBatchSendParam.AliyunSmsSendParamBuilder templateCode(String templateCode) {
            if (templateCode == null || templateCode.equals("")) {
                throw new IllegalArgumentException("templateCode can not be null");
            }
            this.templateCode = templateCode;
            return this;
        }

        public AliyunSmsBatchSendParam.AliyunSmsSendParamBuilder signName(Collection<String> signName) {
            if (signName == null || signName.isEmpty()) {
                throw new IllegalArgumentException("signName can not be null");
            }
            this.signName = JSON.toJSONString(signName);
            return this;
        }

        public AliyunSmsBatchSendParam.AliyunSmsSendParamBuilder phoneNumbers(Collection<String> phoneNumbers) {
            if (phoneNumbers == null || phoneNumbers.isEmpty()) {
                throw new IllegalArgumentException("phoneNumbers can not be null");
            }
            this.phoneNumbers = JSON.toJSONString(phoneNumbers);
            return this;
        }

        public AliyunSmsBatchSendParam build() {
            if (this.templateCode == null) throw new IllegalArgumentException("templateCode can not be null");
            if (this.signName == null) throw new IllegalArgumentException("signName can not be null");
            if (this.phoneNumbers == null) throw new IllegalArgumentException("phoneNumbers can not be null");
            return new AliyunSmsBatchSendParam(this.codeJson, this.templateCode, this.signName, this.phoneNumbers);
        }

        public String toString() {
            return "AliyunSmsSendParam.AliyunSmsSendParamBuilder(codeJson=" + this.codeJson + ", templateCode=" + this.templateCode + ", signName=" + this.signName + ", phoneNumbers=" + this.phoneNumbers + ")";
        }
    }
}
