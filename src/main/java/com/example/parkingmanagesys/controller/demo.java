package com.example.parkingmanagesys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class demo {
    @RequestMapping(value = "/demo")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("demo");
        mv.addObject("title","欢迎使用Thymeleaf!");
        return mv;
    }
}
