package com.rj.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Created by 10064028 on 2018/2/11.
 */
@Data
@Component
public class User implements Serializable {
    private static final long serialVersionUID = -922918433784433209L;

    public User(){
        this.name = "r---------------j";
        this.age = 12;
    }
    private String name;
    private Integer age;
}
