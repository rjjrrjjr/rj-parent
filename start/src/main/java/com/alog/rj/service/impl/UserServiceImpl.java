package com.alog.rj.service.impl;

import org.springframework.stereotype.Service;

import com.alog.rj.domain.User;
import com.alog.rj.service.UserService;

/**
 * Created by 10064028 on 2018/1/12.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public User getByUsername(String username) {
        User user = new User();
        user.setName(username);
        return user;
    }
}
