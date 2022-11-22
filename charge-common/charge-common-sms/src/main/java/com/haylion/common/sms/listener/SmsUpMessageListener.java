package com.haylion.common.sms.listener;

import com.aliyun.mns.model.Message;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liyu
 * date 2022/4/13 13:32
 * description  如果发送的短信需要接收对方回复的状态消息，只需实现该接口并初始化一个 Spring Bean 即可
 */
//@Component
@Slf4j
public class SmsUpMessageListener implements com.alibaba.cloud.spring.boot.sms.SmsUpMessageListener {

    @Override
    public boolean dealMessage(Message message) {
        log.info(this.getClass().getName() + "; " + message.toString());
        return true;
    }
}
