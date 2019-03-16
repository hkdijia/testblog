package com.gotkx.testblog;

import com.gotkx.testblog.dao.ArticleDao;
import com.gotkx.testblog.entity.Article;
import com.gotkx.testblog.entity.Category;
import com.gotkx.testblog.service.ArticleService;
import com.gotkx.testblog.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestblogApplicationTests {

    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ArticleDao articleDao;


    @Test
    public void findById(){


        Article article1 = articleService.getById(5);

        System.out.println(article1.getSummary());
    }

    @Test
    public void service(){
        Article article = articleService.getById(5);

        System.out.println(article.getContent());


        /*System.out.println(article.getTitle());
        System.out.println( article.getCategory());
        System.out.println(article.getDate());
        System.out.println( article.getSummary());
        System.out.println(article.getId());*/

        System.out.println("======");

        List<Category> categories = categoryService.list();
        System.out.println(categories);
    }

    @Test
    public void contextLoads() {
    }

}
