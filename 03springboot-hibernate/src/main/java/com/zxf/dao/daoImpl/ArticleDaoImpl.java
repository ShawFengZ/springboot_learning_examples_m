package com.zxf.dao.daoImpl;

import com.zxf.dao.IArticleDAO;
import com.zxf.entity.Article;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author zxf
 * @date 2018/8/16 18:55
 */
public class ArticleDaoImpl implements IArticleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unckecked")
    @Override
    public List<Article> getAllArticles() {
        String hql = "FROM Article as atcl ORDER BY atcl.articleId";
        return (List<Article>) entityManager.createQuery(hql).getResultList();
    }

    //按主键查找
    @Override
    public Article getArticleById(Integer id) {
        return entityManager.find(Article.class, id);
    }

    //插入
    @Override
    @Transactional
    public void addArticle(Article article) {
        entityManager.persist(article);
    }

    //修改
    @Override
    @Transactional
    public void updateArticle(Article article) {
        Article article1 = getArticleById(article.getArticleId());
        BeanUtils.copyProperties(article, article1);
        entityManager.flush();
    }

    //删除
    @Override
    @Transactional
    public void deleteArticle(Article article) {
        entityManager.remove(getArticleById(article.getArticleId()));
    }

    @Override
    public boolean articleExists(String title, String category) {
        String hql = "FROM Article as atcl WHERE atcl.title=? and atcl.category =?";
        int count = entityManager.createQuery(hql).setParameter(0, title)
                .setParameter(1, category).getResultList().size();
        return count>0;
    }

}
