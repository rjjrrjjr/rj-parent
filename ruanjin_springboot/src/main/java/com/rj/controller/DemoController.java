package com.rj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rj.domain.User;
import com.rj.service.UserService;

/**
 * Created by 10064028 on 2018/2/7.
 */
@RestController
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/select")
    public User selectUser(){
        return userService.getUser();
    }
}
