package com.gotkx.testblog.aspect;

import org.apache.tomcat.util.descriptor.web.LoginConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 这里的addPathPatterns("/**")为配置需要拦截的方法“/**”代表所有，
         * 而后excludePathPatterns("/user/toLogin")等方法为排除哪些方法不进行拦截
         */
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/article/**");

                /*

                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/article/**");
                .excludePathPatterns("/user/toLogin")
                .excludePathPatterns("/user/toNewUser")
                .excludePathPatterns("/user/newUser");*/

    }
}
