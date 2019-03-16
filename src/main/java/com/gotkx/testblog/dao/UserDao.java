package com.gotkx.testblog.dao;

import com.gotkx.testblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {

    @Query("from User u where u.username = :username and u.password = :password")
    User findByUsernameAndAndPassword(@Param("username") String username, @Param("password") String password);
}
