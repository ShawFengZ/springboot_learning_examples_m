package com.zxf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxf
 * @date 2018/8/16 21:51
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/world")
    public String hello(){
        return "Hello";
    }
}
