package com.brainacademy.threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
    private static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    long id = Thread.currentThread().getId();

                    System.out.println(id + " Waiting...");
                    semaphore.acquire();

                    System.out.println(id + " Running");
                    TimeUnit.SECONDS.sleep(3);

                    semaphore.release();
                    System.out.println(id + " Release");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
