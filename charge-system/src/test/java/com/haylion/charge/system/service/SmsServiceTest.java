package com.haylion.charge.system.service;

import com.aliyuncs.exceptions.ClientException;
import com.haylion.charge.system.ScmSystemApplication;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.haylion.common.core.constant.RedisConstant.USER_VERIFICATION_CODE_PREFIX;

/**
 * @author liyu
 * date 2022/4/13 17:19
 * description
 */
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = ScmSystemApplication.class)
public class SmsServiceTest {

    @Autowired
    SmsSysService smsSysService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void upload_test() throws IOException, ClientException {
        smsSysService.send(3, "15626250969");

    }

    private void userCodeVerify(String prefix, String code) {
        String key = USER_VERIFICATION_CODE_PREFIX + prefix;
        String verificationCode = stringRedisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(verificationCode) || !verificationCode.equals(code)) {
            log.info("CODE_ERROR_OR_INVALID");
            return;
        }
        stringRedisTemplate.delete(key);
    }
}
