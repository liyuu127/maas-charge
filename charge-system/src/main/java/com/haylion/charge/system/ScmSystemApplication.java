package com.haylion.charge.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2022/4/13 9:32
 */
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan(basePackages = "com.haylion.common.repository.mapper")
public class ScmSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScmSystemApplication.class,args);
    }
}
