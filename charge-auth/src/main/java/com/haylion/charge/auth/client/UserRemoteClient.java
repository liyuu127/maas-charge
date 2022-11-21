package com.haylion.charge.auth.client;

import com.haylion.charge.auth.client.factory.UserRemoteFallbackFactory;
import com.haylion.common.core.model.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liyu
 * date 2022/4/7 16:15
 * description
 */
@FeignClient(contextId = "userRemoteClient", value = "charge-user",path = "/user", fallbackFactory = UserRemoteFallbackFactory.class)
public interface UserRemoteClient {

    @GetMapping("/permissionCode")
    public ResponseData selectPermissionCodeByUsername(@RequestParam(value = "username", required = true) String username);

    /**
     * 查询用户信息及权限信息
     * @param username 手机号或用户名
     * @return
     */
    @GetMapping("/login/info")
    public ResponseData selectLoginInfo(@RequestParam(value = "username", required = true) String username);
}