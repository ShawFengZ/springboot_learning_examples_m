package com.zxf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author zxf
 * @date 2018/8/16 10:21
 */
@Controller
@RequestMapping("index")
@Slf4j
public class IndexController {

    @RequestMapping("/welcome")
    public ModelAndView index(Map<String, Object> map){
        //model.addAttribute("msg", "welcome you!");
        map.put("msg", "welcome you!");
        log.info("【thymeleaf的集成】");
        return new ModelAndView("index", map);
    }
}
