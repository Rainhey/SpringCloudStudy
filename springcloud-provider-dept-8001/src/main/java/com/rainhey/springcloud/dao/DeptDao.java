package com.rainhey.springcloud.dao;

import com.rainhey.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
    public boolean addDept(Dept dept);
    public Dept queryById(long id);
    public List<Dept> queryAll();
}
