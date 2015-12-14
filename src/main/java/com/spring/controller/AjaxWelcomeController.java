package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AjaxWelcomeController {
    
    @RequestMapping("/ajax")
    public ModelAndView go() {
        ModelAndView m = new ModelAndView("ajax");
        return m;
    }
}
