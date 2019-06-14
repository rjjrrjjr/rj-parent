package com.rj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.rj.domain.User;

/**
 * Created by 10064028 on 2018/2/11.
 */
@RestController
public class DemoController {
    @Autowired
    private User user;

    @GetMapping("/select")
    public User getUser(){
        return user;
    }
}
