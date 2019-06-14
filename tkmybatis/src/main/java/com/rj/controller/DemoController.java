package com.rj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rj.model.UserEntity;
import com.rj.service.UserService;

/**
 * Created by 10064028 on 2018/2/24.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "hello,asfsdgdshsgs";
    }

    @GetMapping("/save")
    public UserEntity save(){
        return userService.save();
    }

    @GetMapping("/list")
    public List<UserEntity> list(){
        return userService.select();
    }

}
