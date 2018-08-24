package com.zxf.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author zxf
 * @date 2018/8/16 20:15
 */
@Entity
@Data
@DynamicUpdate
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleId;

    private String title;

    private String category;
}
