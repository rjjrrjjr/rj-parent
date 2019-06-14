package com.example.demo.adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.interceptor.MyInterceptor;

/**
 * Created by 10064028 on 2018/1/25.
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    //自定义资源映射addResourceHandlers
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/my/**").addResourceLocations("file:C:/Users/10064028/Desktop/spring-boot/");

        super.addResourceHandlers(registry);
    }

    //页面跳转addViewControllers
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin").setViewName("login");
        super.addViewControllers(registry);
    }

    //拦截器addInterceptors
//   @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//       registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login");
//       super.addInterceptors(registry);    }
}
