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
    public List<User> list() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
    
}
