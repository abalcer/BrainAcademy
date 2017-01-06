package com.brainacademy.threads;

public class VolatileTest {
    public static int val = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    /**
     * Класс для "прослушивания" изменнений переменной {@link VolatileTest#val}.
     * Если переменная {@link VolatileTest#val} не volatile, то localValue
     * никогда не изменится и получим бесконечный цикл.
     */
    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int localValue = val;
            while (localValue < 5) {
                if (localValue != val) {
                    System.out.println("Got Change for val : " + val);
                    localValue = val;
                }
            }
        }
    }

    /**
     * Класс для изменения переменной {@link VolatileTest#val}.
     */
    static class ChangeMaker extends Thread {
        @Override
        public void run() {
            int localValue = val;
            while (val < 5) {
                System.out.println("Incrementing val to " + (localValue + 1));
                val = ++ localValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
