package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.redis.RedisService;
import com.example.demo.redis.RedisServiceImpl;

/**
 * Created by 10064028 on 2018/11/20.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration
public class TestRedis {

    /*@Autowired
    private RedisTemplate redisTemplate;

    private RedisService redisService = new RedisServiceImpl(redisTemplate);

    @Test
    public void testRedisService(){
        List<Object> list = redisService.lGet("fixed_user_key", 0, -1);
        list.forEach(System.out::println);
    }*/

    @Test
    public void tt(){
        System.out.println("==========================");
    }
}
