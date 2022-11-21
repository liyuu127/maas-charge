package com.haylion.common.log;

import com.haylion.common.log.listener.SysLogListener;
import com.haylion.common.log.aspect.SysLogAspect;
import feign.Logger;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**

 * @Description 当web项目引入此依赖时，自动配置对应的内容 初始化log的事件监听与切面配置

 */
@EnableFeignClients
@EnableAsync
@Configuration
@ComponentScan("com.haylion.common.log")
public class LogAutoConfiguration {

    @Bean
    public SysLogListener sysLogListener() {
        return new SysLogListener();
    }

    @Bean
    public SysLogAspect sysLogAspect(ApplicationEventPublisher publisher) {
        return new SysLogAspect(publisher);
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

