package com.brainacademy.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureUsageTest {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        //Запускаем одну задачу на выполнение.
        Future<Double> future = EXECUTOR_SERVICE.submit(new Calc(5, 6));
        try {
            //Получаем результат.
            double res = future.get();
            System.out.println("Result: " + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //Формируем список задач для ExecutorService
        List<Callable<Double>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Calc(i, i + 1));
        }

        //Запускаем задачи.
        try {
            List<Future<Double>> futures = EXECUTOR_SERVICE.invokeAll(list);
            for (Future<Double> f : futures) {
                System.out.println("Result: " + f.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        EXECUTOR_SERVICE.shutdown();

        try {
            EXECUTOR_SERVICE.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static class Calc implements Callable<Double> {
        double a, b;

        public Calc(double a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public Double call() throws Exception {
            System.out.println("Start calculation");
            TimeUnit.SECONDS.sleep(1);
            return a * b;
        }
    }
}
