package com.rainhey.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
// feign客户端注解,并指定要扫描的包以及配置接口DeptClientService
@EnableFeignClients(basePackages = {
        "com.rainhey.springcloud"})
public class DeptConsumer_8000_feign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_8000_feign.class, args);
    }
}
