package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ConfigBean;
import com.example.demo.service.UserService;

/**
 * Created by 10064028 on 2018/2/2.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private ConfigBean configBean;

    @Override
    public String select() {
        return configBean.getName() + configBean.getWant();
    }
}
