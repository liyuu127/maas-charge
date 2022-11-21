package com.haylion.charge.system.service;


import com.haylion.common.entity.entity.SysLog;
import com.haylion.common.repository.mapper.SysLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 上传接口
 * @author: zengfu
 * @create: 2020-06-11 11:36
 **/
@Slf4j
@Service
public class SysLogService {

    @Autowired
    SysLogMapper sysLogMapper;


    public void insert(SysLog sysLog) {
        sysLogMapper.insertSelective(sysLog);
    }
}
