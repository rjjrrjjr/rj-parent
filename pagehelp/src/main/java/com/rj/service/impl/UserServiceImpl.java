package com.rj.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.rj.domain.UserEntity;
import com.rj.mapper.UserEntityMapper;
import com.rj.service.UserService;

/**
 * Created by 10064028 on 2018/1/31.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserEntityMapper userEntityMapper;

    @Autowired
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    @Override
    public UserEntity select() {
        return userEntityMapper.selectByPrimaryKey(2L);

    }

    @Override
    public List<UserEntity> selectByOneParam(Long id) {
        return userEntityMapper.selectById(id);
    }

    @Override
    public List<UserEntity> listByRowBunds() {
        List<UserEntity> list = null;
        try {
            SqlSession sqlSession = sqlSessionFactoryBean.getObject().openSession();
            Map<String, Object> param = new HashMap<>();
            param.put("id", 1L);
            list = sqlSession.selectList("com.rj.mapper.UserEntityMapper.list", param, new RowBounds(1, 4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<UserEntity> listByStartPage() {
        PageHelper.startPage(2,4);
        //return userEntityMapper.listTest();
        return null;
    }

    @Override
    public List<UserEntity> listAgain() {
        return userEntityMapper.listAgain();
    }
}
