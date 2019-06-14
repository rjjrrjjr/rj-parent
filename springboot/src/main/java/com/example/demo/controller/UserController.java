package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo.model.ConfigBean;
import com.example.demo.model.ConfigTestBean;
import com.example.demo.model.Randomabc;

/**
 * Created by 10064028 on 2018/1/22.
 */
@RestController
public class UserController {

    @Autowired
    private Randomabc random;
    @Autowired
    private ConfigBean configBean;
    @Autowired
    private ConfigTestBean configTestBean;

    @GetMapping({"/index", "/"})
    public String index(){
        return "userController: " + configBean.getName() + configBean.getWant() + configBean.getYearhope();
    }

    @GetMapping("/test")
    public String test(){
        return configTestBean.getName() + configTestBean.getWant();
    }

    @GetMapping("/random")
    public String random(){
        System.out.println(random.getValue());
        System.out.println(random.getNumber());
        System.out.println(random.getUuid());
        System.out.println(random.getBignumber());
        System.out.println(random.getLess());
        System.out.println(random.getRange());
        return random.getValue() + random.getNumber() + random.getUuid() + random.getBignumber() + random.getLess() + random.getRange();
    }
}
