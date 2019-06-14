package com.rj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by 10064028 on 2018/2/9.
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class ApiConfig {
    //springfox为我们提供了一个Docket（摘要的意思）类
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(""))
//                .paths(PathSelectors.any())
//                .build()
                ;
    }

    //springfox允许我们将信息组合成一个ApiInfo的类，作为构造参数传给Docket
    private ApiInfo apiInfo() {
        Contact contact = new Contact("小明", "http://www.cnblogs.com/getupmorning/", "zhaoming0018@126.com");
        return new ApiInfoBuilder()
                .title("前台API接口")
                .description("前台API接口")
                .contact(contact)
                .version("1.1.0")
                .build();
    }

}
