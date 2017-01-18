package com.brainacademy.decorator;

public class MainPrintable implements Printable {
    @Override
    public void print() {
        System.out.print(getResult());
    }

    @Override
    public String getResult() {
        return "Hello";
    }
}
