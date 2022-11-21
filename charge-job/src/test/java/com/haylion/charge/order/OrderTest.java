package com.haylion.charge.order;

import com.haylion.common.core.exception.BaseException;
import com.haylion.common.core.model.ResponseData;
import com.haylion.common.dfs.client.ItemCodeClient;
import com.haylion.common.dfs.client.PurchasesClient;
import com.haylion.common.dfs.model.purchase.PageResultPurchaseEntity;
import com.haylion.common.dfs.model.purchase.PurchaseEntity;
import com.haylion.common.dfs.model.purchase.PurchasesListReq;
import com.haylion.charge.JobExecutorApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liyu
 * date 2022/4/13 17:19
 * description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JobExecutorApplication.class)
@Slf4j
public class OrderTest {

    @Autowired
    PurchasesClient purchasesClient;

    @Autowired
    PurchaseService purchaseService;
    @Autowired
    ItemCodeClient itemCodeClient;

    @Test
    public void purchases_list_test() {
//        ResponseData<List<PurchaseEntity>> responseData = purchasesClient.queryPurchasesListByUpdateTime("2021-09-01 00:00:00", "2022-10-08 14:35:50");
        PurchasesListReq purchasesListReq = new PurchasesListReq();
        purchasesListReq.setUpdateStartTime("2021-09-01 00:00:00");
        purchasesListReq.setUpdateEndTime("2022-10-09 14:35:50");
        ResponseData<PageResultPurchaseEntity> responseData = purchasesClient.queryPurchasesPage(purchasesListReq);
        System.out.println("responseData = " + responseData);
    }

    @Test
    public void sync_purchases_list_test() {
        try {
            purchaseService.syncPurchaseByUpdateTime();
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

}
