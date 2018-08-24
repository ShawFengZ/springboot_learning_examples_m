package com.zxf.repository;

import com.zxf.entity.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zxf
 * @date 2018/8/16 20:17
 */
public interface ArticleRepository extends JpaRepository<Articles, Integer> {
    Articles findByArticleId(Integer articleId);
}
