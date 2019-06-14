package com.example.demo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by 10064028 on 2018/1/22.
 */
@ConfigurationProperties(prefix = "com.md")
@Configuration
@PropertySource("classpath:test.properties")
public class ConfigTestBean {

    private String name;
    private String want;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }
}
