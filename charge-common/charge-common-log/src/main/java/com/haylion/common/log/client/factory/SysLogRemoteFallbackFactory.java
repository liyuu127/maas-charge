package com.haylion.common.log.client.factory;

import com.haylion.common.log.client.SysLogRemoteClient;
import com.haylion.common.log.client.fallback.SysLogRemoteFallbackImpl;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author liyu
 * date 2021/5/7 15:19
 * description
 */
@Component
public class SysLogRemoteFallbackFactory implements FallbackFactory<SysLogRemoteClient> {

    @Override
    public SysLogRemoteClient create(Throwable throwable) {
        return new SysLogRemoteFallbackImpl(throwable);
    }
}
