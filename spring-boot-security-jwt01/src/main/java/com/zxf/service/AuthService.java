package com.zxf.service;

import com.zxf.entity.User;

/**
 * @author zxf
 * @date 2018/8/24 11:22
 */
public interface AuthService {

    /**
     * @Author zxf
     * @Description 注册
     * @Date  2018/8/24 11:23
     * @params 需要注册的用户
     * @return
    */
    User register(User userToAdd);
    
    /**
     * @Author zxf
     * @Description 登录
     * @Date  2018/8/24 11:24
     * @params 
     * @return 
    */
    String login(String username, String password);

    /**
     * @Author zxf
     * @Description 刷新token
     * @Date  2018/8/24 11:25
     * @params 
     * @return 
    */
    String refresh(String oldToken);
}
