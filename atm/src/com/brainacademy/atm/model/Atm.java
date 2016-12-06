package com.brainacademy.atm.model;

import java.util.ArrayList;
import java.util.List;

public class Atm {
    private double totalAmount;
    private double dailyAmount;
    private ArrayList<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getDailyAmount() {
        return dailyAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setDailyAmount(double dailyAmount) {
        this.dailyAmount = dailyAmount;
    }

    public boolean isCardValid(Card card) {
        return cards.contains(card);
    }
}
