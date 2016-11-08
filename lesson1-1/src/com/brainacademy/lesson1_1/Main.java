package com.brainacademy.lesson1_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Input name: ");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        System.out.println("Your input: " + name);
    }
}
