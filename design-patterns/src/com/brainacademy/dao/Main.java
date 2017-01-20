package com.brainacademy.dao;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setAge(29);
        user.setEmail("some@mail.net");
        user.setName("Vasya");

        UserDao userDao = new UserDao();
        userDao.save(user);

        User user1 = userDao.findOne(1L);
        System.out.println("User found: " + user1.getName());

    }
}
