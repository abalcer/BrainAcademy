package com.brainacademy.atm.service;

import java.util.HashMap;
import java.util.Map;

import com.brainacademy.atm.model.Atm;
import com.brainacademy.atm.model.Card;
import com.brainacademy.atm.model.Client;

public class AtmService {
    private final Atm atm = new Atm();
    private final HashMap<Card, Double> dailyCash = new HashMap<>();

    private Card currentCard;

    public boolean start(Card card, int pin) {
        if (atm.isCardValid(card) && card.checkPin(pin)) {
            currentCard = card;
            return true;
        } else {
            return false;
        }
    }

    public double getCash(double cash) {
        double withdrawСash = cash;

        if (currentCard != null) {
            double totalAmount = atm.getTotalAmount();
            if (withdrawСash > totalAmount) {
                withdrawСash = totalAmount;
            }

            if (currentCard.getBalance() <= withdrawСash) {
                return 0;
            }

            double totalDailyCash = dailyCash.containsKey(currentCard) ? dailyCash.get(currentCard) : 0;
            if ((totalDailyCash + withdrawСash) > atm.getDailyAmount()) {
                withdrawСash = atm.getDailyAmount() - totalDailyCash;
            }

            currentCard.take(withdrawСash);
            dailyCash.put(currentCard, totalDailyCash + withdrawСash);
            atm.setTotalAmount(totalAmount - withdrawСash);

            return withdrawСash;
        } else {
            return 0;
        }
    }


    public double putCash(Card card, double cash) {
        return 0;
    }

    public double getBalance(Card card) {
        return card.getBalance();
    }

    public void reset() {
        currentCard = null;
    }

    public void addCard(Card card) {
        atm.addCard(card);
    }
}
