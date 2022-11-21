package com.haylion.charge.order;

import com.alibaba.fastjson.JSONObject;
import com.haylion.common.core.model.FeignResponseData;
import com.haylion.common.dfs.client.ItemCodeClient;
import com.haylion.common.dfs.model.itemCode.ItemCodeRuleEntity;
import com.haylion.charge.JobExecutorApplication;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

/**
 * @author liyu
 * date 2022/4/13 17:19
 * description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JobExecutorApplication.class)
@Slf4j
public class ItemCodeClientTest {
    @Autowired
    ItemCodeClient itemCodeClient;

    @Test
    public void testGetRules() throws IOException {
        FeignResponseData<List<ItemCodeRuleEntity>> rules = itemCodeClient.getRules("22");
        log.info(new ObjectMapper().writeValueAsString(rules));
    }

    @Test
    public void testGetRuleDetailById(){
        log.info(JSONObject.toJSONString(itemCodeClient.getRuleDetailById(22)));
    }

    @Test
    public void testGetPrintRule(){
        log.info(JSONObject.toJSONString(itemCodeClient.getPrintRule("purchaseSingleProductCode")));
    }
}
