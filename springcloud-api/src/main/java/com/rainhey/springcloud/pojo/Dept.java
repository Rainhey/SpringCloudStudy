package com.rainhey.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)  //链式写法
public class Dept implements Serializable {
    private long deptno;
    private String dname;
    private String db_source;

    public Dept(long deptno) {
        this.deptno = deptno;
    }


}
