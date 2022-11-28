package com.haylion.charge.auth.handler;

import com.haylion.common.auth.model.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @Classname prexAuthenticationSuccessHandler
 * @Description 在验证过程中成功会触发此类事件
 */
@Slf4j
@Component
public class AuthenticationSuccessEventHandler implements ApplicationListener<AuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {

        Authentication authentication = (Authentication) event.getSource();
        if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof SecurityUser) {
                log.info("用户：{} 登录成功", ((SecurityUser) principal).getUsername());
                //todo update login time
            }
        }
    }
}


