package com.brainacademy.music.model;

public class Director extends User {

    public Director() {
        super("director");
    }

    public String toString() {
        return "Director: " + name + ", " + phone + ", " + email;
    }
}
