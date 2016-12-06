package com.brainacademy.music.model;

public class User {
    protected String name;
    protected String phone;
    protected String email;

    private String position;

    public User() {
    }

    public User(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }
}
