package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.example.demo.model.ConfigBean;

@EnableConfigurationProperties({ConfigBean.class})
@SpringBootApplication	//开启自动配置
public class ApplicationRJ extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ApplicationRJ.class, args);
	}

}
