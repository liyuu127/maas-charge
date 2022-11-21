package com.haylion.charge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author haylion
 */
@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = "com.haylion.common.repository.mapper")
public class JobExecutorApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobExecutorApplication.class, args);
    }

}