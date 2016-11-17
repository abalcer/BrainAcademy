package com.brainacademy.arrays;

public class Main {

    public static final int TOTAL_ELEMENTS = 100000;

    public static void linerialSort(int[] array) {
        int min, idx;

        for (int i = 0; i < array.length; i++) {
            min = array[i];
            idx = i;
            for (int j = i; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    idx = j;
                }
            }
            array[idx] = array[i];
            array[i] = min;
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    exchange(array, i, j);
                    swapped = true;
                }
            }
            //print(array);
            if (! swapped) {
                break;
            }
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = array[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (array[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (array[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(array, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j) {
            quickSort(array, low, j);
        }
        if (i < high) {
            quickSort(array, i, high);
        }
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {

        int a[] = new int[TOTAL_ELEMENTS];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }

        long time = System.currentTimeMillis();
        quickSort(a.clone(), 0, a.length - 1);
        double timeQuickSort = (double) (System.currentTimeMillis() - time) / 1000;
        System.out.println("QS: " + timeQuickSort);

        time = System.currentTimeMillis();
        linerialSort(a.clone());
        double timeLinerialSort = (double) (System.currentTimeMillis() - time) / 1000;
        System.out.println("LS: " + timeLinerialSort);

        time = System.currentTimeMillis();
        bubbleSort(a.clone());
        double timeBubbleSort = (double) (System.currentTimeMillis() - time) / 1000;
        System.out.println("BS: " + timeBubbleSort);



        //int a[] = new int[]{ 5, 6, 3, 4, 2, 1 };
        //print(a);

    }
}
