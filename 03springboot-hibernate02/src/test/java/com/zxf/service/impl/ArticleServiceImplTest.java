package com.zxf.service.impl;

import com.zxf.entity.Articles;
import com.zxf.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ArticleServiceImplTest {

    @Autowired
    private ArticleService articleService;

    //实体类的名要和数据库中的表的名对应
    @Test
    public void findAll() {
        List<Articles> articlesList = articleService.findAll();
        Assert.assertNotEquals(0, articlesList.size());
    }

    /**
     * 不加主键，要在实体的id上加上注解@GeneratedValue(strategy = GenerationType.IDENTITY)
     * @GeneratedValue(strategy = GenerationType.AUTO)还不行
     * */
    @Test
    public void addArticle() {
        Articles article = new Articles();
        article.setCategory("Math");
        article.setTitle("The beauty of Math");
        articleService.addArticle(article);
    }

    @Test
    public void deleteArticle() {
        Articles articles = articleService.findByArticleId(4);
        articleService.deleteArticle(articles);
    }

    @Test
    public void updateArticle() {
        Articles articles = articleService.findByArticleId(5);
        Articles newArticles = new Articles();
        newArticles.setTitle("Chinese");
        newArticles.setArticleId(articles.getArticleId());
        newArticles.setCategory("Chinese");
        articleService.updateArticle(newArticles);
    }

    @Test
    public void findByArticleId() {
        Articles articles = articleService.findByArticleId(4);
        Assert.assertNotNull(articles);
    }
}