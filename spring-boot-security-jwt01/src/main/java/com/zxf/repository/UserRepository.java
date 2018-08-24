package com.zxf.repository;

import com.zxf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zxf
 * @date 2018/8/23 10:12
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
