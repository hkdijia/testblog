package com.gotkx.testblog.service;

import com.gotkx.testblog.dao.UserDao;
import com.gotkx.testblog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public String login(String username, String password){
        User user = userDao.findByUsernameAndAndPassword(username,password);
        if (null == user){
            return "该用户不存在";
        }else {
            return "登录成功";
        }
    }
}
