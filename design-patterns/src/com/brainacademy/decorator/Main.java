package com.brainacademy.decorator;

public class Main {
    public static void main(String[] args) {
        Printable printable = new MainPrintable();
        Printable decorator1 = new QuotePrintableDecorator(printable);
        Printable decorator2 = new QuotePrintableDecorator(decorator1);
        Printable decorator3 = new BracketPrintableDecorator(printable);
        Printable decorator4 = new BracketPrintableDecorator(decorator1);
        Printable decorator5 = new BracketPrintableDecorator(decorator2);


        System.out.println(printable.getResult());
        System.out.println(decorator1.getResult());
        System.out.println(decorator2.getResult());
        System.out.println(decorator3.getResult());
        System.out.println(decorator4.getResult());
        System.out.println(decorator5.getResult());

    }
}
