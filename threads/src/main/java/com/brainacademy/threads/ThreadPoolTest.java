package com.brainacademy.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            EXECUTOR_SERVICE.execute(() -> {
                System.out.println(Thread.currentThread().getId() + ", " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        EXECUTOR_SERVICE.shutdown();
        EXECUTOR_SERVICE.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Finish");
    }
}
