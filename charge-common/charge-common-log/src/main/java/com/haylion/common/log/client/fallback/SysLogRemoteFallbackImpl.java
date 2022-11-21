package com.haylion.common.log.client.fallback;

import com.haylion.common.entity.entity.SysLog;
import com.haylion.common.core.model.ResponseData;
import com.haylion.common.log.client.SysLogRemoteClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liyu
 * date 2021/5/7 15:22
 * description
 */
@Slf4j
@AllArgsConstructor
public class SysLogRemoteFallbackImpl implements SysLogRemoteClient {

    private final Throwable throwable;


    @Override
    public ResponseData insert(SysLog sysLog) {
        log.info("feign 调用失败{}", throwable.getLocalizedMessage());
        return ResponseData.fail(throwable.getLocalizedMessage());
    }
}
