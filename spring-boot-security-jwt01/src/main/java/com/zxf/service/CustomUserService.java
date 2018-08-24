package com.zxf.service;

import com.zxf.entity.User;
import com.zxf.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author zxf
 * @date 2018/8/23 10:25
 */
@Service
@Slf4j
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        log.info("【用户名】：{}",user.getUsername());
        log.info("【密码】：{}",user.getPassword());
        log.info("【角色】：{}",user.getAuthorities());
        return user;
    }
}
