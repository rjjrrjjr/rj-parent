package com.rj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by 10064028 on 2018/2/7.
 */
@Component
public class UserConfig {

    @Autowired
    private Environment environment;

    @Value("${local.name}")
    private String localName;

    @Value("${local.port}")
    private Integer port;

    @Value("${tomcat.port:10000}")
    private Long tomcatPort;

    public void show(){
        System.out.println(environment.getProperty("local.ip"));
        System.out.println(environment.getProperty("local.port", Integer.class));
        System.out.println(localName);
        System.out.println(port);
        System.out.println(tomcatPort);

        System.out.println(environment.getProperty("local.url"));
    }

}
