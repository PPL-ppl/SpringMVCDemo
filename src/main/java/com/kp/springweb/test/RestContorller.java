package com.kp.springweb.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestContorller {
    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/rest", produces = "text/plain;charset=UTF-8")
    public String rest(Model model) {
        model.addAttribute("msg", demoService.sayHi());
        return demoService.sayHi();
    }
}
