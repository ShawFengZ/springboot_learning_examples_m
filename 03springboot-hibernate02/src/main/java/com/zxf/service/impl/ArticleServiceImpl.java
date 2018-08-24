package com.zxf.service.impl;

import com.zxf.entity.Articles;
import com.zxf.repository.ArticleRepository;
import com.zxf.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zxf
 * @date 2018/8/16 20:22
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository repository;

    @Override
    public List<Articles> findAll() {
        List<Articles> articlesList = repository.findAll();
        return articlesList;
    }

    @Override
    public void addArticle(Articles articles) {
        repository.save(articles);
    }

    @Override
    public void deleteArticle(Articles articles) {
        repository.delete(articles);
    }

    @Override
    public void updateArticle(Articles articles) {
        repository.save(articles);
    }

    @Override
    public Articles findByArticleId(Integer articleId) {
        Articles articles =  repository.findByArticleId(articleId);
        return articles;
    }
}
