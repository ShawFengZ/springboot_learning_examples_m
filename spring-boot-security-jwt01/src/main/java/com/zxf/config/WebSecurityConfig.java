package com.zxf.config;

import com.zxf.service.CustomUserService;
import com.zxf.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zxf
 * @date 2018/8/23 10:56
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    protected UserDetailsService customUserService(){
        return new CustomUserService();
    }

    //装载BCrypt密码编码器
    /*@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }*/


    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder
                .userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                log.info("【rawPassword】encode:{}", rawPassword);
                return MD5Util.encode((String) rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodePassword) {
                log.info("【rawPassword】matches:{}", rawPassword);
                log.info("【encodePassword】matches:{}", encodePassword);
                log.info("【是否相等】：{}",encodePassword.equals(MD5Util.encode((String) rawPassword)));
                return encodePassword.equals(MD5Util.encode((String) rawPassword));
            }
        });
        //authenticationManagerBuilder.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).
          //      withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN");

                /*// 设置UserDetailService
                .userDetailsService(customUserService())
                // 使用BCrypt进行密码的hash
                .passwordEncoder(passwordEncoder());*/
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }*/

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            //由于使用的是JWT，这里不需要csrf
           // .csrf().disable()
            //基于token，所以不需要session
           // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            //允许对静态资源的无授权访问
            .antMatchers(
                    HttpMethod.GET,
                    //"/",
                    //"/*.html",
                    //"/favicon.ico",
                    //"/**/*.html",
                    "/**/*.css",
                    "/**/*.js"
            ).permitAll()
            // 对于获取token的rest api要允许匿名访问
            .antMatchers("/auth/**").permitAll()
            .antMatchers("/admin/**").hasIpAddress("localhost")
            .antMatchers("/admin/**").access("hasAuthority('ROLE_ADMIN')")
            .anyRequest().authenticated().and().formLogin().loginPage("/login")
            .failureUrl("/login?error").permitAll().and().logout().permitAll();
            // 除上面的所有请求外都要鉴权认证



    }
}
