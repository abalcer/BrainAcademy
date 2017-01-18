package com.brainacademy.builder;

public class Main {
    public static void main(String[] args) {
        User user = User.builder()
                //Заполняем поля step-by-step
                .name("Name")
                .email("somwe@email.net")
                .age(20)
                //Создаем объет User
                .build();

        System.out.println(String.format("Name: %s\nEmail: %s\nAge: %d",
                user.getName(), user.getEmail(), user.getAge()));
    }
}
