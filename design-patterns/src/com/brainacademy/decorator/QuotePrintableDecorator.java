package com.brainacademy.decorator;

public class QuotePrintableDecorator implements Printable {
    private final Printable printable;

    public QuotePrintableDecorator(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void print() {
        System.out.println(getResult());
    }

    @Override
    public String getResult() {
        return "\"" + printable.getResult() + "\"";
    }
}
