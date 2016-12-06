package com.brainacademy.atm.service;

import java.util.HashMap;
import java.util.Map;

import com.brainacademy.atm.model.Atm;
import com.brainacademy.atm.model.Card;
import com.brainacademy.atm.model.Client;

public class AtmService {
    private final Atm atm = new Atm();
    private final Map<Card, Double> dailyCash = new HashMap<>();

    private Card currentCard;

    public boolean verifyClient(Client client, int pin) {
        Card card = client.getCard();
        if (atm.contains(client) && card.checkPin(pin)) {
            currentCard = card;
            return true;
        } else {
            return false;
        }
    }

    public double getCash(Card card, double cash) {
        double withdrawСash = cash;

        if (currentCard != null && currentCard.equals(card)) {
            double totalAmount = atm.getTotalAmount();
            if (withdrawСash > totalAmount) {
                withdrawСash = totalAmount;
            }

            if (currentCard.getBalance() <= cash) {
                return 0;
            }

            double totalDailyCash = dailyCash.containsKey(card) ? dailyCash.get(card) : 0;
            if ((totalDailyCash + withdrawСash) > atm.getDailyAmount()) {
                withdrawСash = atm.getDailyAmount() - totalDailyCash;
            }

            currentCard.take(withdrawСash);
            dailyCash.put(card, totalDailyCash + withdrawСash);
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

    public boolean addClient(Client client) {
        if (client.getCard() == null) {
            return false;
        } else {
            atm.addClient(client);
            return true;
        }
    }
}
