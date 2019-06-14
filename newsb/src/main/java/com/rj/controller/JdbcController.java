package com.rj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rj.service.UserService;

/**
 * Created by 10064028 on 2018/3/13.
 */
@RestController
public class JdbcController {

    @Autowired
    private UserService userService;

    @GetMapping("/insert")
    public void insert(){
        userService.createUser("rj", 999);
    }
}
