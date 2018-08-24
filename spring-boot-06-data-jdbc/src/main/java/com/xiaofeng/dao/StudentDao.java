package com.xiaofeng.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zxf
 * @date 2018/8/24 15:07
 */
@Repository
public class StudentDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Map<String, Object> getStudent(Integer id){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from student");
        return list.get(id);
    }
}
