package com.brainacademy.observer;

/**
 * Общий интерфейс для управление подпиской.
 */
public interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
}
