package com.brainacademy.mvc;

public class StudentController {
    public Student createStudent(String name, String group, String school) {
        Student student = new Student();
        student.setName(name);
        student.setGroup(group);
        student.setSchool(school);
        return student;
    }
}
