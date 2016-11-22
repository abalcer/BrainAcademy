package com.brainacademy.arrays;

import java.util.Arrays;

public class RegularizeArray {

    private static int[] add(int[] a, int b) {
        int idx = 0;
        while (idx < a.length && b >= a[idx]) {
            idx++;
        }

        int[] newA = new int[a.length + 1];
        for (int i = 0; i < idx; i++) {
            newA[i] = a[i];
        }
        newA[idx] = b;

        for (int i = idx + 1; i < newA.length; i++) {
            newA[i] = a[i - 1];
        }
        return newA;
    }

    private static int[] remove(int a[], int b) {
        int idx = - 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b) {
                idx = i;
                break;
            }
        }

        if (idx == - 1) {
            return a;
        }

        int[] newA = new int[a.length - 1];
        for (int i = 0; i < idx; i++) {
            newA[i] = a[i];
        }
        for (int i = idx; i < newA.length; i++) {
            newA[i] = a[i + 1];
        }

        return newA;
    }

    public static void main(String[] args) {
        int[] a = new int[]{ 1, 3, 4, 5, 6 };

        int[] newA = remove(a, 1);
        System.out.println(Arrays.toString(newA));

        newA = add(a, 3);
        System.out.println(Arrays.toString(newA));
    }
}
