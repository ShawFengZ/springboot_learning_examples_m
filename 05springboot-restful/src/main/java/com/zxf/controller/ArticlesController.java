package com.zxf.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zxf.entity.Articles;
import com.zxf.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zxf
 * @date 2018/8/16 21:39
 */
@RestController
@RequestMapping(value = "/articles")
public class ArticlesController {

    @Autowired
    private ArticleService articleService;

    /**
     * @Author zxf
     * @Description 查询列表
     * @Date  2018/8/16 21:59
     * @params
     * @return
    */
    @GetMapping("/article")
    public Map<String, Object> list(){
        Map<String,Object> map = new HashMap<>();
        List<Articles> articlesList = articleService.findAll();
        map.put("msg", articlesList);
        //return new ModelAndView("/", map);
        return map;
    }

    /**
     * @Author zxf
     * @Description 新增用户，必须发送post请求过来
     * @Date 2018/8/16 22:13
     * @params
     * @return
    */
    @PostMapping("/article")
    public Map<String, Object> createArticle(){
        Map<String,Object> map = new HashMap<>();
        Articles articles = new Articles();
        articles.setCategory("music");
        articles.setTitle("Ashes");
        articleService.addArticle(articles);
        map.put("msg", true);
        return map;
    }

    /**
     * @Author zxf
     * @Description
     * @Date 2018/8/16 22:08
     * @params
     * @return
    */
    //http://localhost:8080/articles/article/1
    @GetMapping("/article/{id}")
    public Map<String, Object> findById(@PathVariable("id") Integer id){
        Map<String,Object> map = new HashMap<>();
        Articles articles = articleService.findByArticleId(id);
        map.put("msg", articles);
        return map;
    }

    /**
     * @Author zxf
     * @Description 删除
     * @Date
     * @params
     * @return
    */
    @DeleteMapping("/article/{id}")
    public Map<String, Object> deleteArticle(@PathVariable("id") Integer id){
        Map<String,Object> map = new HashMap<>();
        Articles articles = new Articles();
        articles.setArticleId(id);
        articles.setCategory("music");
        articles.setTitle("Ashes");
        articleService.deleteArticle(articles);
        map.put("msg", "success");
        return map;
    }

    @PutMapping("/article/{id}")
    public Map<String, Object> updateArticle(@PathVariable("id") Integer id){
        Articles articles = articleService.findByArticleId(id);
        articles.setTitle("JPA");
        articleService.updateArticle(articles);
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "success");
        return map;
    }


}
