package com.rj.domain;

import java.io.Serializable;

/**
 * Created by 10064028 on 2018/3/13.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -922918433784433209L;

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
