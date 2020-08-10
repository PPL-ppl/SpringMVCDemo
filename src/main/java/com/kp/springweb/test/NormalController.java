package com.kp.springweb.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NormalController {
    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/normal")
    public String normal(Model model) {
        model.addAttribute("msh", demoService.sayHi());
        return "page";
    }
}
