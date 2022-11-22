package com.haylion.common.auth.resource;

import com.haylion.common.auth.handler.AuthExceptionEntryPoint;
import com.haylion.common.auth.handler.CustomLogoutSuccessHandler;
import com.haylion.common.auth.token.CustomJwtAccessTokenConverter;
import com.haylion.common.auth.handler.CustomAccessDeniedHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Description oauth2资源服务器
 */
@Slf4j
@Configuration
@EnableResourceServer
@ConditionalOnMissingBean(ResourceServerConfigurerAdapter.class)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    /**
     * security的鉴权排除的url列表
     */
    private static final String[] EXCLUDED_AUTH_PAGES = {
            "/auth/token",
            "/user/password/reset",
            "/user/login/info",
            "/user/register",
            "/file/upload",
            "/file/delete",
            "/log/insert",
            "/sms/send",
            "/appInfo/latest",
            "/internationalization/findAll"
    };

    @Autowired
    CustomLogoutSuccessHandler customLogoutSuccessHandler;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(EXCLUDED_AUTH_PAGES).permitAll()
                .anyRequest()
                .authenticated()

                .and()
                // 默认为 /logout
                .logout()
//                .logoutUrl("/user/logout")
                .logoutSuccessHandler(customLogoutSuccessHandler)
                // 无效会话
                .invalidateHttpSession(true)
                // 清除身份验证
                .clearAuthentication(true)
                .permitAll();

    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .authenticationEntryPoint(new AuthExceptionEntryPoint())
                .accessDeniedHandler(new CustomAccessDeniedHandler());
    }



}
