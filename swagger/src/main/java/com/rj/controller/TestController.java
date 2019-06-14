package com.rj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * Created by 10064028 on 2018/2/11.
 */
@RestController
public class TestController {

    @ApiOperation(value="一个测试API",notes = "第一个测试api")
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
