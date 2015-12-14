package com.spring.dao;

import java.util.List;

import com.spring.model.User;

public interface UserDAO {
    public <T> T get(Class<T> clazz, int id);
    
    public <T> void delete(T rm);
    
    public <T> void saveOrUpdate(T data);
    
    public List<User> list();
    
    public List<User> findByName(String username);
}
