package com.rj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rj.domain.UserEntity;
import com.rj.service.UserService;

/**
 * Created by 10064028 on 2018/1/31.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/select")
    @ResponseBody
    public UserEntity select(){
        return userService.select();
    }

    @ResponseBody
    @GetMapping("/list/again")
    public List<UserEntity> listAgain(){
        return userService.listAgain();
    }

    @PostMapping("/list")
    @ResponseBody
    public List<UserEntity> list(String name, String a){
        System.out.println("name: " + name);
        System.out.println("a: " + a);
        return userService.listByStartPage();
    }
}
