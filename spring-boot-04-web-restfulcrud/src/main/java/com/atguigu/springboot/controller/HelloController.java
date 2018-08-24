package com.atguigu.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello(){
        return "Hello world";
    }

    /*@RequestMapping(value = "/success")
    public String success(Map<String, Object> map){
        map.put("Hello","你好");
        return "success";
    }*/
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
