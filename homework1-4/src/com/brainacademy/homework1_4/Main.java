package com.brainacademy.homework1_4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Input number in range 10...99:");

        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();

        int a = val / 10;
        int b = val % 10;

        System.out.println(a - b);
    }
}
