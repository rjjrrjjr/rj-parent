package com.rj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rj.mapper.UserEntityMapper;
import com.rj.model.UserEntity;
import com.rj.service.UserService;

import tk.mybatis.mapper.entity.Example;

/**
 * Created by 10064028 on 2018/2/24.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public UserEntity save() {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(12);
        userEntity.setName("rj");
        userEntity.setSchoolName("cug");
        userEntityMapper.insert(userEntity);
        return userEntity;
    }

    @Override
    public List<UserEntity> select() {
        Example example = new Example(UserEntity.class);
        example.createCriteria().andEqualTo("age", 12).andEqualTo("name", "rj").andGreaterThanOrEqualTo("id", 25);
        Example.Criteria criteria = example.createCriteria().orEqualTo("id", 4).orLessThan("id", 4);
        example.and(criteria);
        return userEntityMapper.selectByExample(example);
    }
}
