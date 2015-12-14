package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    private int    id;
    @JsonView(Views.Public.class)
    private String username;
    @JsonView(Views.Public.class)
    private String password;
    private String email;
}
