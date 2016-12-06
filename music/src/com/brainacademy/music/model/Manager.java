package com.brainacademy.music.model;

public class Manager extends User {

    public Manager() {
        super("manager");
    }

    public String getName() {
        return "Some" + name;
    }

    public String toString() {
        return "Manager: " + name + ", " + phone + ", " + email;
    }
}
