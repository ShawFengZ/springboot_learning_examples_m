package com.zxf.repository;

import com.zxf.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;
    @Test
    public void findByUsername() {
        User user = repository.findByUsername("zhangsan");
        System.out.println("user"+user.toString());
    }
}