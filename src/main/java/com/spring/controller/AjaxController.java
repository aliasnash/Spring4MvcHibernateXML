package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.spring.dao.UserDAO;
import com.spring.model.AjaxResponseBody;
import com.spring.model.SearchCriteria;
import com.spring.model.User;
import com.spring.model.Views;

// http://www.mkyong.com/spring-mvc/spring-4-mvc-ajax-hello-world-example/
@RestController
public class AjaxController {
    
    @Autowired
    private UserDAO userDao;
    
    @JsonView(Views.Public.class)
    @RequestMapping(path = "/search/api", method = RequestMethod.POST)
    public AjaxResponseBody getSearchResultViaAjax(@RequestBody SearchCriteria search) {
        
        AjaxResponseBody result = new AjaxResponseBody();
        
        if (search != null && !StringUtils.isEmpty(search.getUsername()) && !StringUtils.isEmpty(search.getEmail())) {
            List<User> users = userDao.findByName(search.getUsername());
            if (users != null && !users.isEmpty()) {
                result.setCode("200");
                result.setMsg("");
                result.setResult(users);
            } else {
                result.setCode("204");
                result.setMsg("No user!");
            }
        } else {
            result.setCode("400");
            result.setMsg("Search criteria is empty!");
        }
        
        return result;
    }
}
