package com.brainacademy.atm.model;

import java.util.ArrayList;
import java.util.List;

public class Atm {
    private double totalAmount;
    private double dailyAmount;
    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
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

    public boolean contains(Client client) {
        return clients.contains(client);
    }
}
