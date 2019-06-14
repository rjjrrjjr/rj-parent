package com.rj;

import java.util.Properties;

import javax.swing.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.rj.anno.EnableLog;
import com.rj.config.JDBCConfig;
import com.rj.config.TomcatProperties;
import com.rj.config.UserConfig;
import com.rj.domain.People;
import com.rj.register.MyImportBeanDefinitionRegistar;

@EnableLog(name = {"rj.rj.rj","jr.jr.jr"})
@Import(MyImportBeanDefinitionRegistar.class)
@SpringBootApplication
public class RuanjinSpringbootApplication {

	public static void main(String[] args) {
		//ConfigurableApplicationContext context = SpringApplication.run(RuanjinSpringbootApplication.class, args);
		SpringApplication springApplication = new SpringApplication(RuanjinSpringbootApplication.class);
		/*
		 SpringApplication.setDefaultProperties(Map<String, Object> defaultProperties)
		 SpringApplication.setDefaultProperties(Properties defaultProperties)
		 */
		Properties properties = new Properties();
		properties.put("a1", 123);
		properties.put("a2", 132);
		properties.put("a3", 321);
		springApplication.setDefaultProperties(properties);
		properties.clear();
		ConfigurableApplicationContext context = springApplication.run(args);
		System.out.println("=====================begin===================");
		System.out.println(context.getEnvironment().getProperty("a.b.c"));
		UserConfig userConfig = context.getBean(UserConfig.class);
		userConfig.show();
		System.out.println(context.getEnvironment().getProperty("a1"));
		System.out.println(context.getEnvironment().getProperty("a2"));
		System.out.println(context.getEnvironment().getProperty("a3"));
		JDBCConfig jdbcConfig = context.getBean(JDBCConfig.class);
		System.out.println(jdbcConfig.getUserName() + "-----" + jdbcConfig.getPwd() + "-----" + jdbcConfig.getJdbcUrl() + "-----" + jdbcConfig.getDriver());
		context.getBean(TomcatProperties.class).show();
		People people = context.getBean(People.class);
		System.out.println(people.getName());
		people.show();
		System.out.println("=====================end===================");
		context.close();
	}
}
