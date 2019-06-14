package com.rj.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Created by 10064028 on 2018/2/8.
 */
@Configuration
//@PropertySource({"classpath:jdbc.properties", "classpath:url.properties"})
@PropertySources({@PropertySource("classpath:jdbc.properties"),@PropertySource("classpath:url.properties")})
@Component
@Data
public class JDBCConfig {
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String pwd;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${dricverClassName}")
    private String driver;
}
