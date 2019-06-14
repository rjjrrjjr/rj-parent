package com.rj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 10064028 on 2018/3/13.
 */
@Controller
public class DemoController {

    @ResponseBody
    @GetMapping("/select")
    public String demo(){
        int a = 2/0;
        return null;
    }
}
