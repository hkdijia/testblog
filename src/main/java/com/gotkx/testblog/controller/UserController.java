package com.gotkx.testblog.controller;

import com.gotkx.testblog.entity.Article;
import com.gotkx.testblog.entity.Category;
import com.gotkx.testblog.entity.User;
import com.gotkx.testblog.service.ArticleService;
import com.gotkx.testblog.service.CategoryService;
import com.gotkx.testblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;


    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");


    /**
     * 登录后台
     * @param response
     * @param session
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String doLogin(HttpServletResponse response,
                          HttpSession session,
                          User user,
                          Model model){
        String result = userService.login(user.getUsername(), user.getPassword());
        if (result.equals("登录成功")){
            session.setAttribute("user", user);

            System.out.println(session);
            System.out.println(session.getAttribute("user"));

            model.addAttribute("result", result);

            return "redirect:/admin";

        } else {
            model.addAttribute("error", "用户名或者密码错误");
            System.out.println("false");

            return "admin/login";
        }
    }


    /**
     * 删除文章
     * @param id
     * @return
     */
    @Transactional
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") int id){
        articleService.delete(id);

        return "redirect:/admin";
    }

    /**
     * 保存文章
     * @param article
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Article article){
        //设置种类
        String name = article.getCategory().getName();
        Category category = categoryService.findByName(name);
        article.setCategory(category);
        //设置摘要,取前40字
        if(article.getContent().length() > 40){
            article.setSummary(article.getContent().substring(0, 40 ));
        }else {
            article.setSummary(article.getContent().substring(0, article.getContent().length()));
        }
        article.setDate(simpleDateFormat.format(new Date()));
        articleService.save(article);

        return "redirect:/admin";
    }

    /**
     * 修改文章
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        Article article = articleService.getById(id);

        model.addAttribute("target", article);


        List<Category> categories = categoryService.list();
        model.addAttribute("categories", categories);
        model.addAttribute("article", new Article());

        return "admin/update";
    }

    /**
     * 编写博客
     * @param model
     * @return
     */
    @RequestMapping("/write")
    public String write(Model model){
        List<Category> categories = categoryService.list();
        model.addAttribute("categories", categories);
        model.addAttribute("article", new Article());

        return "admin/write";
    }

    /**
     * 后台主页
     * @param model
     * @return
     */
    @RequestMapping("")
    public String admin(Model model){
        List<Article> articles = articleService.list();
        model.addAttribute("articles", articles);

        return "admin/index";
    }

    /**
     * 登录模块
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpSession session){
        Object user = session.getAttribute("user");
        if ((null == user)){
            return "admin/login";
        }else {
            return "redirect:/admin";
        }

    }


}
