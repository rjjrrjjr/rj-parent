package com.alog.rj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alog.rj.domain.User;

/**
 * Created by 10064028 on 2018/1/12.
 */
@Controller
@RequestMapping("/mydemo")
public class UserController {

    @RequestMapping("/getUserInfo")
    public String getUserInfo(HttpServletRequest request){
        String currentUser = (String) request.getSession().getAttribute("currentUser");
        System.out.println("当前登录的用户为[" + currentUser + "]");
        request.setAttribute("currentUser", currentUser);
        return "/user/info";
    }

    @PostMapping("/post")
    @ResponseBody
    public String testPost(@RequestParam String name){
        return "success";
    }
}
