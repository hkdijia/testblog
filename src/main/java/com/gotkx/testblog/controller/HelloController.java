package com.gotkx.testblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.Date;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Heool Spring Boot";
    }

    @RequestMapping("/html")
    String html(HttpServletRequest request) {
        //逻辑处理
        request.setAttribute("key", "hehe.....");
        return "test2";
    }

    /*@RequestMapping("/")
    public String login(){
        return "redirect:/article";
    }*/

/*
    @RequestMapping("/hi")
    public String hi(Model model){
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hi";
    }
*/


}
