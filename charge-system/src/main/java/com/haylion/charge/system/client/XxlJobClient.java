package com.haylion.charge.system.client;

import com.haylion.charge.system.client.model.ReturnT;
import com.haylion.charge.system.client.model.RunJobReq;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RefreshScope
@FeignClient(value = "xxljob", url = "${mc.xxljob.executor.url}", path = "/")
public interface XxlJobClient {

    @RequestMapping(method = RequestMethod.POST, value = "/run", consumes = "application/json", produces = "application/json")
    ReturnT runJob(@RequestBody RunJobReq runJobReq);

}
