package com.haylion.charge.system.web;


import com.aliyuncs.exceptions.ClientException;
import com.haylion.charge.system.service.SmsSysService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 上传接口
 * @author: zengfu
 * @create: 2020-06-11 11:36
 **/
@Slf4j
@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    SmsSysService smsSysService;


    @GetMapping("/send")
    public void send(@RequestParam(value = "type", required = false, defaultValue = "0") Integer type,
                     @RequestParam(value = "phone", required = true) String phone) throws ClientException {
        smsSysService.send(type, phone);

    }


}
