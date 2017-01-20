package com.brainacademy.mvc;

public class Main {
    public static void main(String[] args) {
        StudentController controller = new StudentController();
        StudentView view = new StudentView();

        Student student = controller.createStudent("Vasya", "EOM-98-01", "#105");
        view.show(student);
    }
}
