package com.gotkx.testblog.service;

import com.gotkx.testblog.dao.CategoryDao;
import com.gotkx.testblog.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public Category findByName(String name){
        return categoryDao.findByName(name);
    }

    /**
     * 查询所有类型
     * @return
     */
    public List<Category> list(){
        List<Category> categories = categoryDao.findAll();

        return categories;
    }
}
