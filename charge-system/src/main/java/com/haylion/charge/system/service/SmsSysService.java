package com.haylion.charge.system.service;


import com.aliyuncs.exceptions.ClientException;
import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.sms.model.AliyunSmsSendParam;
import com.haylion.common.sms.service.AliyunMsgService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.haylion.common.core.constant.RedisConstant.USER_VERIFICATION_CODE_PREFIX;
import static com.haylion.common.core.constant.RedisConstant.VERIFICATION_CODE_CACHE_TIME_SECONDS;
import static com.haylion.charge.system.constant.RetStubDetail.CODE_HAS_ALREADY_SEND;
import static com.haylion.charge.system.constant.SystemConstant.*;

/**
 * @description: 短信
 * @create: 2020-06-11 11:36
 **/
@Slf4j
@Service
public class SmsSysService {

    @Autowired
    AliyunMsgService aliyunMsgService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Value("${mc.sms.sign-name}")
    String signName;

    @Value("${mc.sms.template-code.login}")
    String loginTemplateCode;

    @Value("${mc.sms.template-code.user-identity}")
    String userIdentityTemplateCode;

    @Value("${mc.sms.template-code.register}")
    String registerTemplateCode;

    @Value("${mc.sms.template-code.update-password}")
    String updatePasswordTemplateCode;

    public void send(Integer type, String phone, String prefix) throws ClientException {
        prefix = StringUtils.isBlank(prefix) ? USER_VERIFICATION_CODE_PREFIX : prefix;
        String templateCode = getTemplateCode(type);

        if (stringRedisTemplate.opsForValue().get(prefix + phone) != null) {
            throw new ApplicationException(CODE_HAS_ALREADY_SEND);
        }

        String code = RandomStringUtils.random(SMS_VERIFY_CODE_LENGTH, false, true);
        AliyunSmsSendParam smsSendParam = AliyunSmsSendParam.builder()
                .code(code)
                .phoneNumbers(phone)
                .templateCode(templateCode)
                .signName(signName)
                .build();
        aliyunMsgService.sendSingleCodeMessage(smsSendParam);
        stringRedisTemplate.opsForValue().set(prefix + phone, code, VERIFICATION_CODE_CACHE_TIME_SECONDS, TimeUnit.SECONDS);
    }

    public void send(Integer type, String phone) throws ClientException {
        send(type, phone, null);
    }

    /**
     * 根据类型获取短信模板code
     *
     * @param type
     * @return
     */
    private String getTemplateCode(Integer type) {
        String templateCode;
        switch (type) {
            case SMS_TYPE_USER_IDENTITY:
                templateCode = userIdentityTemplateCode;
                break;
            case SMS_TYPE_LOGIN:
                templateCode = loginTemplateCode;
                break;
            case SMS_TYPE_REGISTER:
                templateCode = registerTemplateCode;
                break;
            case SMS_TYPE_UPDATE_PASSWORD:
                templateCode = updatePasswordTemplateCode;
                break;
            default:
                throw new IllegalArgumentException("type param error");
        }
        return templateCode;
    }
}
