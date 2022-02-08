package com.rainhey.springcloud.service;

import com.rainhey.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);
    public Dept queryById(long id);
    public List<Dept> queryAll();
}
