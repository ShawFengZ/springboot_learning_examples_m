package com.zxf.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zxf
 * @date 2018/8/16 18:46
 */
@Entity
@Data
@Table(name = "articles")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;
}
