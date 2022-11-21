package com.haylion.charge.auth.client.fallback;

import com.haylion.charge.auth.client.UserRemoteClient;
import com.haylion.common.core.model.ResponseData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liyu
 * date 2021/5/7 15:22
 * description
 */
@Slf4j
@AllArgsConstructor
public class UserRemoteFallbackImpl implements UserRemoteClient {

    private final Throwable throwable;


    @Override
    public ResponseData selectPermissionCodeByUsername(String username) {
        log.info("feign 调用失败{}", throwable.getLocalizedMessage());
        return ResponseData.fail(throwable.getLocalizedMessage());
    }

    @Override
    public ResponseData selectLoginInfo(String username) {
        log.info("feign 调用失败{}", throwable.getLocalizedMessage());
        return ResponseData.fail(throwable.getLocalizedMessage());
    }
}
