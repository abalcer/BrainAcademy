package com.brainacademy.web.spring.db.dao;


import com.brainacademy.web.spring.db.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Service
public class UserDaoImpl
        implements UserDao {

    @Autowired
    EntityManager em;

    @Override
    public User findOne(Integer id) {
        TypedQuery<User> query = em.createQuery("from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
