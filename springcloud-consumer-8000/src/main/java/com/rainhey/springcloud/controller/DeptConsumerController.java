package com.rainhey.springcloud.controller;

import com.rainhey.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    //消费者不应该有service层
    //RestTemplate供我们直接调用，注册到spring中
    //RestTemplate 常用参数格式
    /** 1. (url,Class<T> responseType)
    * 2. (url,实体：map，Class<T> responseType*/

    @Autowired
    private RestTemplate restTemplate;  //提供多种边界访问http服务的方法，简单的restful模板

   //public static final String prefixurl="http://localhost:8001";

    //基于Ribbon负载均衡，通过服务名访问
    public static final String prefixurl="http://SPRINGCLOUD-PROVIDER-DEPT";
    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(prefixurl+"/dept/add", dept, boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable long id){
        return restTemplate.getForObject(prefixurl+"/dept/get/"+id, Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(prefixurl+"/dept/list", List.class);
    }
}
