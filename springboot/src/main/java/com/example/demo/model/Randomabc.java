package com.example.demo.model;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 10064028 on 2018/1/22.
 */
@Configuration
@ConfigurationProperties(prefix = "com.rj")
public class Randomabc implements Serializable {
    private static final long serialVersionUID = 8874189196236556423L;

    private Integer number;
    private String value;
    private Long bignumber;
    private String uuid;
    private Double less;
    private String range;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getBignumber() {
        return bignumber;
    }

    public void setBignumber(Long bignumber) {
        this.bignumber = bignumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Double getLess() {
        return less;
    }

    public void setLess(Double less) {
        this.less = less;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
