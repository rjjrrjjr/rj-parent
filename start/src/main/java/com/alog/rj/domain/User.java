package com.alog.rj.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 10064028 on 2018/1/12.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 533642972278150026L;

    private String name;

    private Integer age;

    private List<Role> roles;

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
