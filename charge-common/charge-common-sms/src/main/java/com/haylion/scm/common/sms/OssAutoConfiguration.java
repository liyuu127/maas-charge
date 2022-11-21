package com.haylion.charge.common.sms;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 */
@Configuration
@ConditionalOnWebApplication
@ComponentScan("com.haylion.charge.common.sms")
public class OssAutoConfiguration {

}


