package com.kp.springweb.springmvc2;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController  //返回json格式的控制器
@RequestMapping("/demo2")
public class Controller2 {
    //<a href="demo1/2?age=11&name=你好">
    @RequestMapping(value = "/1", produces = "application/json;charset=UTF-8")
    public DemoOBJ set1(DemoOBJ obj) {
        return obj;
    }

    //<a href="demo2/2?age=11&name=你好"> name2=你好
    @RequestMapping(value = "/2", produces = "application/json;charset=UTF-8")
    public DemoOBJ set2(DemoOBJ obj, @RequestParam("name") String name2) {
        System.out.println(name2 + "=============");
        return obj;
    }

    //返回的是页面字符串  返回的是index字符串
    @RequestMapping(value = "/3")
    public String set3() {
        return "index";
    }
}
