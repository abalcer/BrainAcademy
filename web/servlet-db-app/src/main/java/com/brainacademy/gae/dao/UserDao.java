package com.brainacademy.gae.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.brainacademy.gae.model.User;
import com.brainacademy.gae.utils.HibernateUtils;

import lombok.Getter;

public class UserDao {
    @Getter
    private static UserDao instance = new UserDao();

    public List<User> getAll() {
        try (Session session =  HibernateUtils.openSession()) {
            Query<User> query = session.createQuery("from User", User.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> finByName(String name) {
        try (Session session = HibernateUtils.openSession()) {
            Query<User> query = session.createQuery("from User u where u.name like :name", User.class);
            query.setParameter("name", "%" + name + "%");
            return query.list();
        }
    }

    public void create(User user) {
        try (Session session = HibernateUtils.openSession()) {
            session.save(user);
        }
    }

    public void update(User user) {
        try (Session session = HibernateUtils.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.update(user);
                transaction.commit();
            } catch (RuntimeException e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }
    }

    public void delete(User user) {
        try (Session session = HibernateUtils.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.remove(user);
                transaction.commit();
            } catch (RuntimeException e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }
    }
}
