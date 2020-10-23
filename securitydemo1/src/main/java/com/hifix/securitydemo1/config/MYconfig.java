package com.hifix.securitydemo1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MYconfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置403页面
        http.exceptionHandling().accessDeniedPage("unauth.html");
    http.formLogin()//自定义登陆页面
    .loginPage("/login.html")//登陆页面设置
    .loginProcessingUrl("/user/login")//登陆访问路径
    .defaultSuccessUrl("/test/index").permitAll()
    .and().authorizeRequests().antMatchers("/","/test/hello","/user/login").permitAll()
//    .antMatchers("/test/index").hasAuthority("admins")//单个权限设置使用这个方法
       .antMatchers("/test/index").hasAnyAuthority("admins","manager")//多个权限设置使用这个方法
    .anyRequest().authenticated()
    .and().csrf().disable()//关闭csrf防护
    ;

    }
}
