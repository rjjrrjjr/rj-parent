package com.rj.service;

import org.springframework.stereotype.Service;

import com.rj.domain.User;

/**
 * Created by 10064028 on 2018/2/7.
 */
@Service("userService")
public class UserService {

    public User getUser(){
        User user = new User();
        user.setName("ruanjin");
        user.setAge(18);
        return user;
    }
}
