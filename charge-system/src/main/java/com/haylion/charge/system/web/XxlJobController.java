package com.haylion.charge.system.web;

import com.haylion.common.log.annotation.SysOperateLog;
import com.haylion.charge.system.client.model.RunJobReq;
import com.haylion.charge.system.service.XxlJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyu
 * date 2022/10/19 17:57
 * description
 */
@RestController
@RequestMapping("/xxljob")
public class XxlJobController {
    @Autowired
    XxlJobService xxlJobService;

    @PreAuthorize("hasAuthority('job:trigger')")
    @SysOperateLog(description = "报工记录更新")
    @PostMapping("/run")
    public void runJob(@RequestBody RunJobReq runJobReq) {
        xxlJobService.triggerJob(runJobReq);
    }

}
