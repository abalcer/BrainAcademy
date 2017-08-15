package com.brainacademy.atm.service;

import com.brainacademy.atm.model.Card;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AtmServiceTest {
    private static final int DAILY_LIMIT = 60;
    private static final int TOTAL = 100;

    private AtmService atmService = new AtmService(TOTAL, DAILY_LIMIT);
    private Card card1;
    private Card card2;

    @Before
    public void setUp()
            throws Exception {

        card1 = new Card(1);
        card1.setNumber(1);

        card2 = new Card(2);
        card2.setNumber(2);

        atmService.addCard(card1);
        atmService.addCard(card2);
    }

    @Test
    public void start() {
        boolean res = atmService.start(card1, 1);
        assertTrue(res);

        res = atmService.start(card1, 2);
        assertFalse(res);

        res = atmService.start(new Card(1), 1);
        assertFalse(res);
    }

    @Test
    public void getCash() {
        double balance = 100;
        card1.setBalance(balance);

        atmService.start(card1, 1);
        double cash = atmService.getCash(10);
        assertEquals(10, cash, 0.01);
        assertEquals(90, card1.getBalance(), 0.01);
    }

    @Test
    public void getCashCardLimit() {
        double balance = 10;
        card1.setBalance(balance);

        //Снимаем с 1-ой карточки сумму, больше чем есть на карточке
        atmService.start(card1, 1);
        double cash = atmService.getCash(40);

        //Доллжны получить не больше, чем на карточке
        assertEquals(10, cash, 0.01);
        assertEquals(0, card1.getBalance(), 0.01);
    }

    @Test
    public void getCashDailyLimit() {
        double balance = 100;
        card1.setBalance(balance);

        //Снимаем с 1-ой карточки сумму, больше чем дневной лимит
        atmService.start(card1, 1);
        double cash = atmService.getCash(DAILY_LIMIT + 10);

        //Доллжны получить не больше, чем дневной лимит
        assertEquals(DAILY_LIMIT, cash, 0.01);
        assertEquals(balance - DAILY_LIMIT, card1.getBalance(), 0.01);
        atmService.reset();

        //Проверяем, что для 2-ой карточки дневной лимит не исчерпан
        card2.setBalance(balance);
        atmService.start(card2, 2);
        cash = atmService.getCash(10);
        assertEquals(10, cash, 0.01);
        assertEquals(90, card2.getBalance(), 0.01);
    }

    @Test
    public void getCashTotalLimit() {
        double balance = 100;
        card1.setBalance(balance);

        //Снимаем с 1-ой карточки
        atmService.start(card1, 1);
        atmService.getCash(DAILY_LIMIT);
        atmService.reset();

        //Пробуем снять со 2-ой карточки
        card2.setBalance(balance);
        atmService.start(card2, 2);
        double cash = atmService.getCash(DAILY_LIMIT);

        //После снятия денег с 1-ой карточки, в банкомате осталось 40 едениц.
        assertEquals(40, cash, 0.01);
        assertEquals(60, card2.getBalance(), 0.01);
    }

    @Test
    public void putCash() {
        card1.setBalance(0);

        atmService.start(card1, 1);
        atmService.putCash(100);
        assertEquals(100, card1.getBalance(), 0.01);
    }
}