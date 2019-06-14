package com.alog.rj.service;

import com.alog.rj.domain.User;

/**
 * Created by 10064028 on 2018/1/12.
 */
public interface UserService {


    User getByUsername(String username);
}
