package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import com.spring.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDAOImpl implements UserDAO {
    
    private SessionFactory sessionFactory;
    
    @Transactional
    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> clazz, int id) {
        return (T) sessionFactory.getCurrentSession().get(clazz, id);
    }
    
    @Transactional
    public <T> void delete(T rm) {
        sessionFactory.getCurrentSession().delete(rm);
    }
    
    @Transactional
    public <T> void saveOrUpdate(T data) {
        sessionFactory.getCurrentSession().saveOrUpdate(data);
    }
    
    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> list() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
    
    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> findByName(String username) {
        return sessionFactory.getCurrentSession().createQuery("FROM User WHERE username = :username").setString("username", username).list();
    }
    
}
