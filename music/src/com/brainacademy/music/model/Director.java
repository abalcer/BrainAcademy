package com.brainacademy.music.model;

public class Director extends User {

    public Director() {
        super(UserPosition.DIRECTOR);
    }

    public String toString() {
        return "Director: " + name + ", " + phone + ", " + email;
    }
}
