package com.example.demo.model;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by 10064028 on 2018/1/22.
 */
@ConfigurationProperties(prefix = "com.rj")
public class ConfigBean implements Serializable{

    private static final long serialVersionUID = -1562450232627169191L;
    private String name;
    private String want;
    private String yearhope;

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

    public String getYearhope() {
        return yearhope;
    }

    public void setYearhope(String yearhope) {
        this.yearhope = yearhope;
    }
}
