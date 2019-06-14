package com.rj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by 10064028 on 2018/3/13.
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createUser(String name, Integer age){
        System.out.println("=============");
        jdbcTemplate.update("insert into t_user(name,age) values(?,?)", name, age);

    }
}
