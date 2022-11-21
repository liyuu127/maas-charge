package com.haylion.charge.system.service;

import com.haylion.charge.system.client.XxlJobClient;
import com.haylion.charge.system.client.model.ReturnT;
import com.haylion.charge.system.client.model.RunJobReq;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2022/10/12 10:58
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestJobClient {
    @Autowired
    private XxlJobClient client;

    @Test
    public void test_run() {
        RunJobReq req = RunJobReq.builder()
                .jobId(76)
                .executorHandler("syncPurchaseByUpdateTime")
                .glueType("BEAN")
                .build();
        ReturnT r =client.runJob(req);
        if (200 != r.getCode()) {
            log.error("fail");
        }
        log.info("responseData={}", r);

    }
}
