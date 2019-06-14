package com.rj.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 10064028 on 2018/3/13.
 */
@Controller
public class FreemarkerController {

    @RequestMapping("/index")
    public String index(Map<String, Object> map) {
        map.put("name","美丽的天使...");
        return "index";
    }

    @RequestMapping("/indexAgain")
    public String indexAgain(Map<String, Object> map) {
        map.put("name","###蚂蚁课堂###");
        map.put("sex",1);
        List<String> userlist=new ArrayList<>();
        userlist.add("余胜军");
        userlist.add("张三");
        userlist.add("李四");
        map.put("userlist",userlist);
        return "indexAgain";
    }

    @RequestMapping("/indexJSP")
    public String index() {
        return "index";
    }

}
