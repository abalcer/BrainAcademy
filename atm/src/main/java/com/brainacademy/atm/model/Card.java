package com.brainacademy.atm.model;

public class Card {
    private long number;
    private final int pin;
    private double balance;

    public Card() {
        pin = (int) (Math.random() * Integer.MAX_VALUE);
    }

    public Card(int pin) {
        this.pin = pin;
    }

    public boolean checkPin(int pin) {
        return this.pin == pin;
    }

    public double getBalance() {
        return balance;
    }

    public void take(double money) {
        balance -= money;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
