package com.xiaofeng.service;

import com.xiaofeng.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zxf
 * @date 2018/8/24 15:07
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Map<String, Object> getStudent(Integer id){
        return studentDao.getStudent(id);
    }
}
