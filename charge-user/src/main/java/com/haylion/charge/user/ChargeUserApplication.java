package com.haylion.charge.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liyu
 * date 2022/4/7 14:34
 * description
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.haylion.common.repository.mapper")
public class ChargeUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChargeUserApplication.class, args);
    }
}
