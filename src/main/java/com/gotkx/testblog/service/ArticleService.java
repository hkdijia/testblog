package com.gotkx.testblog.service;

import com.gotkx.testblog.dao.ArticleDao;
import com.gotkx.testblog.entity.Article;
import com.gotkx.testblog.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public List<Article> getArticleByCategoryName(String categoryName){
        return articleDao.findAllByCategory_Name(categoryName);
    }

    /**
     * 查询所有文章
     * @return
     */
    public List<Article> list(){
        List<Article> articles = articleDao.findAll();
        return articles;
    }

    /**
     * 保存文章
     * @param article
     */
    public void save(Article article) {
        articleDao.save(article);
    }

    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    public Article getById(int id) {
        Article article = articleDao.findById(id);
        return article;
    }

    /**
     * 根据id删除文章
     * @param id
     */
    public void delete(int id) {
        articleDao.deleteByCategory_Id(id);
    }

    public List<Article> search(String key) {
        return articleDao.findByTitleLike(key);
    }
}
