package com.haylion.common.notice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@Configuration
@ConditionalOnWebApplication
@ComponentScan("com.haylion.common.notice")
public class SiteNoticeAutoConfiguration {

//    @Bean
//    public SiteNoticeService siteNoticeService() {
//        return new SiteNoticeService();
//    }
}

