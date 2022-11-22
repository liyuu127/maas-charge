package com.haylion.common.sms.service;

import com.alibaba.cloud.spring.boot.sms.ISmsService;
import com.aliyuncs.dysmsapi.model.v20170525.*;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.haylion.common.sms.model.AliyunSmsBatchSendParam;
import com.haylion.common.sms.model.AliyunSmsSendParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * @description: 阿里短信服务
 * https://help.aliyun.com/document_detail/66041.html?spm=a2c4g.11186623.6.571.631315e8AauJhP
 **/
@Slf4j
@Component
public class AliyunMsgService {
    @Autowired
    private ISmsService smsService;

    /**
     * 短信发送 Example
     *
     * @return
     */
    public SendSmsResponse sendSingleCodeMessage(AliyunSmsSendParam aliyunSmsSendParam) throws ClientException {
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(aliyunSmsSendParam.getPhoneNumbers());
        request.setSignName(aliyunSmsSendParam.getSignName());
        request.setTemplateCode(aliyunSmsSendParam.getTemplateCode());
        request.setTemplateParam("{\"code\":\"" + aliyunSmsSendParam.getCode() + "\"}");

        SendSmsResponse sendSmsResponse;
        sendSmsResponse = smsService.sendSmsRequest(request);
        return sendSmsResponse;
    }

    public SendBatchSmsResponse sendBatchCodeMessage(AliyunSmsBatchSendParam aliyunSmsBatchSendParam) throws ClientException {
        // 组装请求对象
        SendBatchSmsRequest request = new SendBatchSmsRequest();
        // 使用 GET 提交
        request.setMethod(MethodType.GET);
        request.setPhoneNumberJson(aliyunSmsBatchSendParam.getPhoneNumbers());
        request.setSignNameJson(aliyunSmsBatchSendParam.getSignName());
        request.setTemplateCode(aliyunSmsBatchSendParam.getTemplateCode());
        request.setTemplateParamJson(aliyunSmsBatchSendParam.getCodeJson());
        SendBatchSmsResponse sendSmsResponse;
        sendSmsResponse = smsService.sendSmsBatchRequest(request);
        return sendSmsResponse;
    }

    public QuerySendDetailsResponse querySendDetailsResponse(@NotNull String telephone, @NotNull String date, Long page, Long pageSize) throws ClientException {
        // 组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        // 必填-号码
        request.setPhoneNumber(telephone);
        // 必填-短信发送的日期 支持30天内记录查询（可查其中一天的发送数据），格式yyyyMMdd
        request.setSendDate(date);
        // 必填-页大小
        request.setPageSize(pageSize == null ? 10L : pageSize);
        // 必填-当前页码从1开始计数
        request.setCurrentPage(page == null ? 1L : page);

        QuerySendDetailsResponse response = smsService.querySendDetails(request);

        return response;
    }
}