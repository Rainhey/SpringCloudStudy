package com.rainhey.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import sun.security.krb5.Config;

@SpringBootApplication
// EurekaServer 服务端启动类，注册中心
@EnableEurekaServer
public class ConfigEurekaServer_7001 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigEurekaServer_7001.class, args);
    }
}
