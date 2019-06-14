package com.rj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rj.service.MybatisService;

/**
 * Created by 10064028 on 2018/3/13.
 */
@RestController
public class MybatisController {

    @Autowired
    private MybatisService mybatisService;

    @GetMapping("/insert1")
    public void save(){
        mybatisService.insert();
    }
}
