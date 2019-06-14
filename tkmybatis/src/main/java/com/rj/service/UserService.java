package com.rj.service;

import java.util.List;

import com.rj.model.UserEntity;

/**
 * Created by 10064028 on 2018/2/24.
 */
public interface UserService {

    UserEntity save();

    List<UserEntity> select();
}
