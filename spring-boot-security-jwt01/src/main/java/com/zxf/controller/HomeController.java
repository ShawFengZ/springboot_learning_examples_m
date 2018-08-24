package com.zxf.controller;

import com.zxf.entity.Msg;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zxf
 * @date 2018/8/23 10:38
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @ResponseBody
    @RequestMapping(value = "/admin/test1")
    public String adminTestUser(){
        return "ROLE_USER";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseBody
    @RequestMapping(value = "/admin/test2")
    public String adminTestAdmain(){
        return "ROLE_ADMIN";
    }


}
