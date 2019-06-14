package com.rj.service;

import java.util.List;

import com.rj.domain.UserEntity;

/**
 * Created by 10064028 on 2018/1/31.
 */
public interface UserService {

    UserEntity select();

    List<UserEntity> selectByOneParam(Long id);

    List<UserEntity> listByRowBunds();

    List<UserEntity> listByStartPage();

    List<UserEntity> listAgain();
}
