package com.alog.entity;

import java.io.Serializable;

/**
 * Created by 10064028 on 2018/1/8.
 */
public class EntityA implements Serializable{

    private static final long serialVersionUID = 2947193471990237479L;

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
