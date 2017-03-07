package com.brainacademy.web.spring.db.repository;

import com.brainacademy.web.spring.db.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}