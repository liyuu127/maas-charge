package com.haylion.charge.common.sms.listener;

import com.aliyun.mns.model.Message;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liyu
 * date 2022/4/13 13:33
 * description 如果需要监听短信是否被对方成功接收，只需实现这个接口并初始化一个 Spring Bean 即可
 */
//@Component
@Slf4j
public class SmsReportMessageListener implements com.alibaba.cloud.spring.boot.sms.SmsReportMessageListener {

    private List<Message> smsReportMessageSet = new LinkedList<>();

    @Override
    public boolean dealMessage(Message message) {
        smsReportMessageSet.add(message);
        log.info(this.getClass().getName() + "; " + message.toString());
        return true;
    }

    public List<Message> getSmsReportMessageSet() {
        return smsReportMessageSet;
    }


}