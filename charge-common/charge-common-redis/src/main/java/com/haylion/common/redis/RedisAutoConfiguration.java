package com.haylion.common.redis;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 当web项目引入此依赖时，自动配置对应的内容 初始化log的事件监听与切面配置
 */
@Configuration
@ComponentScan("com.haylion.common.redis")
public class RedisAutoConfiguration {

}

