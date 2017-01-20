package com.brainacademy.mvc;

public class StudentView {
    public void show(Student student) {
        System.out.println("Name: " + student.getName());
        System.out.println("Group: " + student.getGroup());
        System.out.println("School: " + student.getSchool());
    }
}
