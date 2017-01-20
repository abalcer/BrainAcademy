package com.brainacademy.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для публикации сообщений и оповещении подписчиков.
 */
public class MessageSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;


    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.message);
        }
    }

    public void post(String message) {
        this.message = message;
        System.out.println("Message posted: " + message);
        notifyObservers();
    }
}
