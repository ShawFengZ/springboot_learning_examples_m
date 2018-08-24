package com.zxf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zxf
 * @date 2018/8/23 10:51
 */
@SuppressWarnings("deprecation")
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    //没有登录的用户都跳转到login页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}
