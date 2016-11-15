package com.brainacademy.homework1_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Input array length:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Input a[" + i + "]:");
            a[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                sum += a[i];
            }
        }

        System.out.println("Result: " + sum);
    }
}
