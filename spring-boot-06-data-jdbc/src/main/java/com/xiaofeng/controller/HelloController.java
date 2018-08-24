package com.xiaofeng.controller;

import com.xiaofeng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author zxf
 * @date 2018/8/8 17:50
 */
@Controller
public class HelloController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @GetMapping("/query")
    public Map<String, Object> map(@RequestParam("id")Integer id){
        //List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from student");
        return studentService.getStudent(id);
    }
}
