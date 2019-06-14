package com.rj.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rj.domain.User;
import com.rj.service.UserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rj
 * @since 2018-01-30
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/select")
    public User select(){
        return userService.selectById(2L);
    }

    @GetMapping("/insert")
    public Boolean insert(){
        User user = new User();
        user.setName(UUID.randomUUID().toString().substring(0, 30));
        user.setAge(20);
        user.setGender(1);
        user.setSchoolName("cug");
        userService.insert(user);
        return true;
    }

    @GetMapping("/list")
    public List<User> list(){
        return userService.selectList(new Wrapper<User>() {
            @Override
            public String getSqlSegment() {
                return null;
            }
        });
    }

    @GetMapping("/selectBySomething")
    public User selectBySomething(){
        return userService.selectOne(new Wrapper<User>() {
            @Override
            public String getSqlSegment() {
                return null;
            }
        });
    }

}

