package com.brainacademy.threads;

public class SynchronizedTest {
    public static Integer val = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
//        new NonSynchronizedThread("NonSync1").start();
//        new NonSynchronizedThread("NonSync2").start();

        new SynchronizedThread("Sync1").start();
        new SynchronizedThread("Sync2").start();
    }


    private static void changeVal() {
        while (val < 5) {
            val++;
            System.out.println(String.format("%s: %d", Thread.currentThread().getName(), val));
        }
        val = 0;
    }

    static class SynchronizedThread extends Thread {

        public SynchronizedThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (lock) {
                changeVal();
            }
        }
    }

    static class NonSynchronizedThread extends Thread {
        public NonSynchronizedThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            changeVal();
        }
    }
}
