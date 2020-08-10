package com.kp.springweb.controllerAdivce;

import com.kp.springweb.springmvc2.DemoOBJ;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controllerAdivce {
    @RequestMapping("/doSomeThing")
    public String doSomeThing(DemoOBJ obj) {
        System.out.println("==============AdviceController");
        throw new IllegalArgumentException("age=" + obj.getAge() + "name=" + obj.getName());
    }

    @RequestMapping("/doSomeThing1")  //取msg得值
    public String doSomeThing1(@ModelAttribute("msg") String msg, DemoOBJ obj) {
        System.out.println("==============AdviceController");
        throw new IllegalArgumentException("age=" + obj.getAge() + "name=" + obj.getName() + "msg" + msg);
    }

   /* @ExceptionHandler(value = Exception.class)
    public ModelAndView handle(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error",e.getMessage());
        modelAndView.setViewName("msg"); //WEB-INF/classes/views/mg.jsp
        return modelAndView; 控制器里也能定义
    }*/
}
