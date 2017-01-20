package com.brainacademy.observer;

public class Main {
    public static void main(String[] args) {
        MessageSubject subject = new MessageSubject();

        // Создаем несколько наблюдателей и добавляем их в subject.
        for (int i = 0; i < 5; i++) {
            Observer observer = new MessageObserver(i);
            subject.register(observer);
        }

        subject.post("Hello");
    }
}
