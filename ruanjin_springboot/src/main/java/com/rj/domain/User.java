package com.rj.domain;

import java.io.Serializable;

import com.rj.anno.EnableLog;

import lombok.Data;

/**
 * Created by 10064028 on 2018/2/7.
 */
@Data
public class User implements Serializable {

    private String name;

    private Integer age;
}
