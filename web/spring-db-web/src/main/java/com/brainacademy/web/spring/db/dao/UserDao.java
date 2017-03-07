package com.brainacademy.web.spring.db.dao;

import com.brainacademy.web.spring.db.model.User;

public interface UserDao {
    User findOne(Integer id);
}
