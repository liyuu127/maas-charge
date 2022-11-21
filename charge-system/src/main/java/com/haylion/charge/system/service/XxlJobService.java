package com.haylion.charge.system.service;

import com.haylion.common.core.exception.ApplicationException;
import com.haylion.charge.system.client.XxlJobClient;
import com.haylion.charge.system.client.model.ReturnT;
import com.haylion.charge.system.client.model.RunJobReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.haylion.charge.system.constant.RetStubDetail.RUN_XXJJOB_ERROR;

/**
 * @author liyu
 * date 2022/10/19 17:57
 * description
 */
@Service
public class XxlJobService {

    @Autowired
    XxlJobClient xxlJobClient;

    public void triggerJob(RunJobReq runJobReq) {
        ReturnT returnT = xxlJobClient.runJob(runJobReq);
        if (200 != returnT.getCode()) {
            throw new ApplicationException(RUN_XXJJOB_ERROR);
        }
    }
}
