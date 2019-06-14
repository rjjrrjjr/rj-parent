package com.rj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rj.mapper.MybatisMapper;

/**
 * Created by 10064028 on 2018/3/13.
 */
@Service
public class MybatisService {

    @Autowired
    private MybatisMapper mybatisMapper;

    public void insert(){
        mybatisMapper.insert("r======j", 0);
    }
}
