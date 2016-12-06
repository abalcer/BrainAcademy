package com.brainacademy.music.model;

public class Manager extends User {

    public Manager() {
        super(UserPosition.MANAGER);
    }

    public String toString() {
        return "Manager: " + name + ", " + phone + ", " + email;
    }
}
