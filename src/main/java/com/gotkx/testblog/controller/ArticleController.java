package com.gotkx.testblog.controller;

import com.gotkx.testblog.entity.Article;
import com.gotkx.testblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tautua.markdownpapers.Markdown;
import org.tautua.markdownpapers.parser.ParseException;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/get/{id}")
    public String get(Model model, @PathVariable(name = "id") int id){
        return "index";
    }

    /**
     * 显示详细信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model){
        System.out.println(id);
        Article article = articleService.getById(id);
        System.out.println(article.getId());
        Markdown markdown = new Markdown();
        try {
            StringWriter out = new StringWriter();
            markdown.transform(new StringReader(article.getContent()), out);
            out.flush();
            article.setContent(out.toString());
        }catch (ParseException e){
            e.printStackTrace();
        }
        model.addAttribute("article", article);

        return "front/detail";
    }

    @RequestMapping("/search")
    public String search(String key, Model model){
        List<Article> articles = articleService.search(key);
        model.addAttribute("articles", articles);

        return "front/columnPage";
    }


    /**
     * 按类型显示博客
     * @param displayname
     * @param category
     * @param model
     * @return
     */
    @RequestMapping("/column/{displayname}/{category}")
    public String column(@PathVariable("displayname") String displayname,
                         @PathVariable("category") String category,
                         Model model){
        model.addAttribute("articles", articleService.getArticleByCategoryName(category));
        model.addAttribute("displayName",displayname);

        return "front/columnPage";
    }

    /**
     * 分页
     * @param model
     * @return
     */
    @RequestMapping("")
    public String list(Model model){
        List<Article> articles = articleService.list();
        model.addAttribute("articles", articles);

        return "front/index";
    }
}
