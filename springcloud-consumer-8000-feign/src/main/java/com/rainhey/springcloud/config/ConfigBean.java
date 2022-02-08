package com.rainhey.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    //配置负载均衡实现RestTemplate
    @LoadBalanced  //ribbon
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    /*负载均衡策略主要是实现IRule这个接口，Ribbon自带一些负载均衡策略
    * RoundRobinRule 轮询策略
    * RandomRule 随机策略
    * AvailabilityFilteringRule ： 会先过滤掉，跳闸，访问故障的服务~，对剩下的进行轮询~
    * RetryRule ： 会先按照轮询获取服务~，如果服务获取失败，则会在指定的时间内进行，重试*/

    //要想使用自带的某种负载均衡策略，只需将其注入容器
    //比如想要使用随机策略
    @Bean
    public IRule myIRule(){
        return new RandomRule();
    }
}
