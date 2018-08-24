package com.zxf.service;

import com.zxf.entity.Articles;

import java.util.List;

/**
 * @author zxf
 * @date 2018/8/16 20:18
 */
public interface ArticleService {

    /** 查询所有 */
    List<Articles> findAll();

    /** 增 */
    void addArticle(Articles articles);

    /** 删 */
    void deleteArticle(Articles articles);

    /** 改 */
    void updateArticle(Articles articles);

    /** 查 */
    Articles findByArticleId(Integer articleId);
}
