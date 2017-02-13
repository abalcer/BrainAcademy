package com.brainacademy.gui.db.service;

import java.util.Collections;
import java.util.List;

import com.brainacademy.gui.db.dao.UserDao;
import com.brainacademy.gui.db.model.User;

import lombok.Getter;

public class UserService {
    @Getter
    private static UserService instance = new UserService();
    private UserDao userDao;

    private UserService() {
        userDao = UserDao.getInstance();
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    public List<User> findByName(String name) {
        if (name == null) {
            return Collections.emptyList();
        }
        return userDao.finByName(name);
    }

    public void save(User user) {
        if (user == null) {
            return;
        }

        if (user.getId() == null) {
            userDao.create(user);
        } else {
            userDao.update(user);
        }
    }

    public void delete(User user) {
        if(user == null) {
            return;
        }

        userDao.delete(user);
    }
}
