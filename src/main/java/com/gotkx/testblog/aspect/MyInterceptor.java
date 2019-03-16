package com.gotkx.testblog.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getRequestURI().equals("/admin/login")
                || request.getRequestURI().equals("/admin/dologin")) {
            return true;
        }

        /*|| request.getRequestURI().equals("/"))*/

        Object user = request.getSession().getAttribute("user");
        if(user == null){
            response.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }
}
