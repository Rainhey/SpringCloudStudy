package com.rainhey.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rainhey.springcloud.pojo.Dept;
import com.rainhey.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable long id){
        Dept dept = deptService.queryById(id);
        if(dept==null){
            throw new RuntimeException("id="+id+"不存在该用户");
        }
        return dept;
    }

    // 备选方案
    public Dept hystrixGet(@PathVariable long id){
        return new Dept().setDeptno(id)
                .setDname("id="+id+"没有对应信息,null @hystrix")
                .setDb_source("no this db in database");
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

}
