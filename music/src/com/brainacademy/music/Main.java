package com.brainacademy.music;

import com.brainacademy.music.model.Director;
import com.brainacademy.music.model.Manager;

public class Main {
    static final String[] data = {
            "3",
            "Анастасия Драпеко", "123-45-67", "drapeko@yandex.ru",
            "Денис Орлов", "873-12-23", "pr.orlov@gmail.com",
            "Лиза Феофановаs", "542-78-67", "liza_velvet@mail.ru",

            "5",
            "Маша Гойя", "1",
            "Вера Брежнева", "2",
            "Ёлка", "1",
            "Группа КЛЮЧИ", "3",
            "Альбина Джанабаева", "1",

            "Маша Гойя",
            ""
    };


    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setName("M1");

        Director director = new Director();
        director.setName("D1");

        String name = manager.getName();
        System.out.println(name);

        System.out.println(director.getName());
    }
}
