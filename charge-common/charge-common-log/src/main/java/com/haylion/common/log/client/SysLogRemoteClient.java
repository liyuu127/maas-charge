package com.haylion.common.log.client;

import com.haylion.common.entity.entity.SysLog;
import com.haylion.common.core.model.ResponseData;
import com.haylion.common.log.client.factory.SysLogRemoteFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author liyu
 * date 2022/4/7 16:15
 * description
 */
@FeignClient(contextId = "logTableRemoteClient", value = "charge-system",url = "localhost:8006",path = "/log", fallbackFactory = SysLogRemoteFallbackFactory.class)
public interface SysLogRemoteClient {

    @PostMapping("/insert")
    public ResponseData insert(@RequestBody SysLog sysLog);
}