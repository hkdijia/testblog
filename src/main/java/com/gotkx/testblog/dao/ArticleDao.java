package com.gotkx.testblog.dao;

import com.gotkx.testblog.entity.Article;
import org.apache.ibatis.annotations.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao extends JpaRepository<Article, String> {

    public Article findById(int id);

    public List<Article> findAllByCategory_Name(String name);

    @Query("from Article where title like %:title%")
    public List<Article> findByTitleLike(@Param("title")String title);

    @Modifying
    @Query("delete from Article where id = ?1")
    void deleteByCategory_Id(int id);
}
