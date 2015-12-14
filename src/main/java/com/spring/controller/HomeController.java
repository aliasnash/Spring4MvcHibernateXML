package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.UserDAO;
import com.spring.model.User;

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
    
    @RequestMapping("/new")
    public ModelAndView newUser() {
        ModelAndView m = new ModelAndView("edit");
        m.addObject("user", new User());
        return m;
    }
    
    @RequestMapping("/edit")
    public ModelAndView editUser(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDao.get(User.class, id);
        ModelAndView m = new ModelAndView("edit");
        m.addObject("user", user);
        return m;
    }
    
    @RequestMapping("/delete")
    public ModelAndView deleteUser(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDao.get(User.class, id);
        userDao.delete(user);
        ModelAndView m = new ModelAndView("redirect:/");
        return m;
    }
    
    @RequestMapping("/save")
    public ModelAndView saveUser(@ModelAttribute User user) {
        userDao.saveOrUpdate(user);
        ModelAndView m = new ModelAndView("redirect:/");
        return m;
    }
}
