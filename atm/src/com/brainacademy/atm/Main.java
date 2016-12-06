package com.brainacademy.atm;


import com.brainacademy.atm.model.Client;
import com.brainacademy.atm.service.AtmService;

public class Main {
    public static void main(String[] args) {
        AtmService atmService = new AtmService();
        atmService.addClient(new Client());

    }
}
