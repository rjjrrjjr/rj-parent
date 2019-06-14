package com.rj.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rj.domain.Cat;
import com.rj.service.impl.DemoService;

/**
 * Created by 10064028 on 2018/2/7.
 */
public class demo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:service-context.xml");
        Object date = context.getBean("date");
        System.out.println(date);
        System.out.println("=================================");
        ((DemoService)context.getBean("demoService")).getBean();
        System.out.println("===================end============");
        System.out.println(((Cat)context.getBean("CCat")).getName() + ((Cat)context.getBean("CCat")).getAge());
    }
}
