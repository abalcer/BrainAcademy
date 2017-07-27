package com.brainacademy.lesson1_2_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter the name of the student: ");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        System.out.println("The name of the student: " + name);
    }
}
