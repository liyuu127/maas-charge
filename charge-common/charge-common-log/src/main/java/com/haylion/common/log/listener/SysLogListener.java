package com.haylion.common.log.listener;

import com.haylion.common.entity.entity.SysLog;
import com.haylion.common.log.client.SysLogRemoteClient;
import com.haylion.common.log.event.SysLogEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * @Classname SysLogListener
 * @Description 注解形式的监听 异步监听日志事件
 */
@Slf4j
public class SysLogListener {

    @Autowired
    private SysLogRemoteClient logTableRemoteClient;

    @Async
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        SysLog sysLog = (SysLog) event.getSource();
        // 保存日志
        logTableRemoteClient.insert(sysLog);
    }
}
