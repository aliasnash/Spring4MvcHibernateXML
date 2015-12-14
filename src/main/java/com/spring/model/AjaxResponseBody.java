package com.spring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AjaxResponseBody {
    
    @JsonView(Views.Public.class)
    private String     msg;
                       
    @JsonView(Views.Public.class)
    private String     code;
                       
    @JsonView(Views.Public.class)
    private List<User> result;
}
