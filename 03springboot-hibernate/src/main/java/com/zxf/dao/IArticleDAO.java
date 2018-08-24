package com.zxf.dao;

import com.zxf.entity.Article;

import java.util.List;

/**
 * @author zxf
 * @date 2018/8/16 18:53
 */
public interface IArticleDAO {
    List<Article> getAllArticles();

    Article getArticleById(Integer id);

    void addArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(Article article);

    boolean articleExists(String title, String category);
}
