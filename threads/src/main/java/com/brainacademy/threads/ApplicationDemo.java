package com.brainacademy.threads;

import java.util.concurrent.CountDownLatch;

public class ApplicationDemo {
    private static final int TOTAL_THREADS = 10;
    private static final int TOTAL_POINTS = 5000;
    private static int x0;

    private static double calc(double x, int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.pow(Math.log(x) * Math.sin(x * x), i + 1) - Math.cos(x * x) * Math.pow(x, i - 1);
        }

        return sum;
    }

    private static void runInSequence() {
        double x = x0;
        for (int i = 0; i < TOTAL_POINTS; i++) {
            calc(x, i);
            x += 0.1;
        }
    }

    private static void runInParrarel() {
        int step = TOTAL_POINTS / TOTAL_THREADS;
        CountDownLatch latch = new CountDownLatch(TOTAL_THREADS);

        for (int i = 0; i < TOTAL_THREADS; i++) {
            int start = i * step;
            int end = Math.min((i + 1) * step, TOTAL_POINTS - 1);

            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Start thread #" + finalI);
                    calcInRange(start, end);
                    System.out.println("End thread #" + finalI);
                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void calcInRange(int start, int end) {
        for (int i = start; i < end; i++) {
            double x = x0 + i * 0.01;
            calc(x, i);
        }
    }

    public static void main(String[] args) {

        boolean isRunSequence = true;
        if(args != null && args.length > 0) {
            isRunSequence = "s".equals(args[0]);
        }

        x0 = 1;
        long time = System.currentTimeMillis();

        if(isRunSequence) {
            runInSequence();
        } else {
            runInParrarel();
        }

        System.out.println(System.currentTimeMillis() - time);

    }
}
