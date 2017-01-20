package com.brainacademy.observer;

/**
 * Класс-наблюдатель за подписками.
 */
public class MessageObserver implements Observer {
    private int id;

    public MessageObserver(int id) {
        this.id = id;
    }

    @Override
    public void update(String message) {
        System.out.printf("Observer #%d: recive message \"%s\"\r\n", id, message);
    }
}
