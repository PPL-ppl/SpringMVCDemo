package com.kp.springweb.springmvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/DemoOBJ")
public class DemoOBJcontroller {
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    @ResponseBody//直接对象 这样才返回对象
    public String index(HttpServletRequest request) {
        return "url" + request.getRequestURI();
    }

    @RequestMapping(value = "/doSth/{str}/", produces = "text/plain;charset=UTF-8")
    @ResponseBody//直接对象
    public String doSth(@PathVariable String str, @PathVariable("str") String str2, HttpServletRequest request) {
        return "url" + request.getRequestURI() + str + str2;
    }

    //"DemoOBJ/requestParm?age=1&name=22.22"
    @RequestMapping(value = "/requestParm", produces = "text/plain;charset=UTF-8")
    @ResponseBody//直接对象
    public String requestParm(int age, String name, HttpServletRequest request) {
        return "url" + request.getRequestURI() + age + name;
    }

    //转json格式  要xml的将json改为xml   value可以配置多路径
    @RequestMapping(value = "/requestParm2", produces = "application/json;charset=UTF-8")
    @ResponseBody//直接对象
    public DemoOBJ requestObj(DemoOBJ obj, HttpServletRequest request) {
        return obj;
    }
}
