package com.rj.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by 10064028 on 2018/2/8.
 */
@Data
public class People implements Serializable {

    private static final long serialVersionUID = -4709034644642012208L;

    private String name;
    private Integer age;

    public People(){
        this.name = "rj";
        this.age = 12;
    }

    public void show(){
        System.out.println("@EnableLog 成功使用");
    }
}
