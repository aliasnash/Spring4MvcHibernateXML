package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.UserDAO;

@Controller
public class HomeController {
    
    @Autowired
    private UserDAO userDao;
    
    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView m = new ModelAndView("home");
        m.addObject("userList", userDao.list());
        return m;
    }
}
