package com.kp.springweb.converter;

import com.kp.springweb.springmvc2.DemoOBJ;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConverterController {
    @RequestMapping(value = "/convert", produces = "application/x-kp;charset=UTF-8")
    @ResponseBody
    public Object test(@RequestBody DemoOBJ demoOBJ) {
        demoOBJ.setAge(demoOBJ.getAge() + 10);
        return demoOBJ;
    }
}
