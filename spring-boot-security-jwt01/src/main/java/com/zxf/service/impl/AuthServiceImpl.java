package com.zxf.service.impl;

import com.zxf.entity.User;
import com.zxf.repository.UserRepository;
import com.zxf.service.AuthService;
import com.zxf.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author zxf
 * @date 2018/8/24 11:26
 */
@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private UserRepository repository;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            UserRepository repository
    ){

    }

    @Override
    public User register(User userToAdd) {
        return null;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public String refresh(String oldToken) {
        return null;
    }
}
