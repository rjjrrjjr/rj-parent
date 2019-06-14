package com.rj.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Created by 10064028 on 2018/2/8.
 */
@Component
@ConfigurationProperties(prefix = "ds")
@Data
public class TomcatProperties {

    private List<String> hosts = new ArrayList<>();

    private String[] ports;

    public void show(){
        System.out.println("hosts=========" + this.hosts);
        System.out.println("ports=========" + this.ports[0] + this.ports[1] + this.ports[2]);
    }
}
