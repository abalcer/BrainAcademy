package com.brainacademy.atm;


import com.brainacademy.atm.model.Atm;
import com.brainacademy.atm.model.Card;
import com.brainacademy.atm.model.Client;
import com.brainacademy.atm.service.AtmService;

public class Main {
    public static void main(String[] args) {
        AtmService atmService = new AtmService(10000, 1000);

        Card[] cards = new Card[5];
        for (int i = 0; i < 5; i++) {
            Card card = new Card(i);
            card.setBalance(2000);
            card.setNumber((int) (Math.random() * Integer.MAX_VALUE));
            cards[i] = card;

            atmService.addCard(card);
        }

        boolean res = atmService.start(cards[0], 0);
        if (!res) {
            System.out.println("Pin code incorrect");
            return;
        }

        double cash = atmService.getCash(500);
        System.out.println(cash);

        cash = atmService.getCash(600);
        System.out.println(cash);

        System.out.println(atmService.getBalance());
        atmService.reset();


    }
}
