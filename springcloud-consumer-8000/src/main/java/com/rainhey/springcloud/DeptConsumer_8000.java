package com.rainhey.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer_8000 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_8000.class, args);
    }
}
