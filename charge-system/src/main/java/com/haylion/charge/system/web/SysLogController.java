package com.haylion.charge.system.web;


import com.haylion.common.entity.entity.SysLog;
import com.haylion.charge.system.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 上传接口
 * @create: 2020-06-11 11:36
 **/
@Slf4j
@RestController
@RequestMapping("/log")
public class SysLogController {

    @Autowired
    SysLogService logTableService;


    @PostMapping("/insert")
    public void insert(@RequestBody SysLog sysLog) {
        logTableService.insert(sysLog);

    }


}
