package com.brainacademy.object;

import java.util.Arrays;

public class Simple {

    public static void main(String[] args) {
        Number number = new Number(1234453321);
        number.print();

        System.out.println(Arrays.toString(number.getDigits()));
        System.out.println("Is symmetric: " + number.isSymmetric());

        Number a = new Number(4);
        Number b = new Number(5);

        Number c = Number.add(a, b);
        c.print();

        System.out.println("Is Equals: " + a.equals(b));
        System.out.println("Is Equals: " + a.equals(a));
        System.out.println("Is Equals: " + a.equals(new Number(4)));

    }
}
