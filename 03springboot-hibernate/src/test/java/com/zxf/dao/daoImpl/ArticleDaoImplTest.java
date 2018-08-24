package com.zxf.dao.daoImpl;

import com.zxf.dao.IArticleDAO;
import com.zxf.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ArticleDaoImplTest {

    @Autowired
    private IArticleDAO iArticleDAO;

    @Test
    public void getAllArticles() {
        List<Article> articleList = iArticleDAO.getAllArticles();
        Assert.assertNotNull(articleList);
    }

    @Test
    public void getArticleById() {
        Article article = iArticleDAO.getArticleById(1);
        Assert.assertNotNull(article);
    }

    @Test
    public void addArticle() {
        Article article = new Article();
        article.setCategory("PHP");
        article.setTitle("十天精通php");
        iArticleDAO.addArticle(article);
    }


    @Test
    public void updateArticle() {
        Article article = new Article();
        article.setArticleId(1);
        article.setTitle("Php and Java");
        article.setCategory("Php");
        iArticleDAO.updateArticle(article);
    }

    @Test
    public void deleteArticle() {
        Article article = iArticleDAO.getArticleById(3);
        iArticleDAO.deleteArticle(article);
    }

    @Test
    public void articleExists() {
        boolean exists = iArticleDAO.articleExists("Php and Java", "Php");
        Assert.assertTrue(exists);
    }
}