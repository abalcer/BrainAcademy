package com.brainacademy.atm.service;

import com.brainacademy.atm.model.Atm;
import com.brainacademy.atm.model.Card;

import java.util.HashMap;

public class AtmService {
    private final Atm atm = new Atm();
    private final HashMap<Card, Double> dailyCash = new HashMap<>();

    private Card currentCard;

    public AtmService(double total, double daily) {
        atm.setTotalAmount(total);
        atm.setDailyAmount(daily);
    }

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
                withdrawСash = currentCard.getBalance();
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


    public double putCash(double cash) {
        if (currentCard != null) {
            currentCard.setBalance(cash);
            return cash;
        }
        return 0;
    }

    public double getBalance() {
        return currentCard.getBalance();
    }

    public void reset() {
        currentCard = null;
    }

    public void addCard(Card card) {
        atm.addCard(card);
    }
}
