package com.brainacademy.object;

import java.util.Arrays;

public class Simple {

    public static void main(String[] args) {
        Number number = new Number(1234453321);
        System.out.println(Arrays.toString(number.getDigits()));
        System.out.println(number.isSymmetric());

        number.print();


    }
}
