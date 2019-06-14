package com.rj.service.impl;

import org.springframework.stereotype.Service;

import lombok.Data;

/**
 * Created by 10064028 on 2018/2/7.
 */
@Service("demoService")
public class DemoService {

    public void getBean(){
        System.out.println("successs");
    }
}
