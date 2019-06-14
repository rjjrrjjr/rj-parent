package com.rj.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rj.domain.Cat;

/**
 * Created by 10064028 on 2018/2/9.
 */

@RestController
public class SwaggerController {

    @Autowired
    private Date date;

    @GetMapping("/select")
    public Cat select(){
        Cat cat = new Cat();
        cat.setName("rj");
        cat.setAge(12);
        return cat;
    }

    @GetMapping("/getTime")
    public Date getTime(){
        return date;
    }
}
