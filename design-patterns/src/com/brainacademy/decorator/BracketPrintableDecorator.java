package com.brainacademy.decorator;

public class BracketPrintableDecorator implements Printable {
    private final Printable printable;

    public BracketPrintableDecorator(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void print() {
        System.out.println(getResult());
    }

    @Override
    public String getResult() {
        return "(" + printable.getResult() + ")";
    }
}
