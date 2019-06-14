package com.rj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rj.domain.Cat;

/**
 * Created by 10064028 on 2018/2/7.
 */
@Configuration
public class Myconfig {

    @Bean
    public Cat CCat(){
        Cat cat = new Cat();
        cat.setName("rj");
        cat.setAge(12);
        return cat;
    }
}
