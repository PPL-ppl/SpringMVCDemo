package com.kp.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Hello {
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("=====================");
        //InternalResourceViewResolver 解析
        //return "index";// /views/index.jsp
        //return "forward:index.jsp";// /WEB-INF/classes/views/index.jsp 服务端转发
        //return "redirect:index.jsp";//浏览器重定向
        return "index";
    }

    @RequestMapping("/hello1")
    //需要什么类型的变量 就声明声明变量
    public String hello1(HttpServletRequest request, Model model) {
        System.out.println("=====================");
        request.setAttribute("rep", "request"); //将值带回页面
        model.addAttribute("mo", "model");
        return "index";
    }
}
