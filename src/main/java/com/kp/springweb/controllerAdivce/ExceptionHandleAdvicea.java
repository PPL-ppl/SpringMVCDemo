package com.kp.springweb.controllerAdivce;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice//处理控制器里的异常  可以单独写在控制器中
public class ExceptionHandleAdvicea {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handle(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", e.getMessage());
        modelAndView.setViewName("msg"); //WEB-INF/classes/views/mg.jsp
        return modelAndView;
    }

    //添加内容
    @ModelAttribute
    public void add(Model mv) {
        System.out.println("ModelAttribute在执行");
        mv.addAttribute("msg", "额外的信息");
    }

    //干预赋值
    @InitBinder
    public void initBinder(WebDataBinder web) {
        web.setDisallowedFields("age");  //即使传值 也不会赋值到对应参数
    }

}
