package com.atguigu.springboot.config;


import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/atguigu请求来到success
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
    }

}
