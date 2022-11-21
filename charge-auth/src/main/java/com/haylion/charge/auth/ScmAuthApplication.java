package com.haylion.charge.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liyu
 * date 2022/4/7 14:37
 * description
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableTransactionManagement
public class ScmAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScmAuthApplication.class, args);
    }
}
