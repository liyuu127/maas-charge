package com.haylion.charge.commom.sms.model;

import com.alibaba.fastjson.JSON;
import com.haylion.charge.common.sms.model.AliyunSmsBatchSendParam;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author liyu
 * date 2022/4/13 14:54
 * description
 */
public class AliyunParamTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AliyunParamTest.class);

    @Test
    public void test_AliyunSmsBatchSendParam_build() {
        List<String> tels = Arrays.asList("15626250933", "15626198730");
        List<String> signs = Arrays.asList("aliyun1", "aliyun2");
        String codes = "code1";
        String templateCode = "templateCode";
        AliyunSmsBatchSendParam build = AliyunSmsBatchSendParam.builder()
                .codeJson(codes)
                .phoneNumbers(tels)
                .signName(signs)
                .templateCode(templateCode)
                .build();
        LOGGER.info("AliyunSmsBatchSendParam={}", build.toString());
        LOGGER.info("codes={}", JSON.toJSONString(codes));
    }
}
