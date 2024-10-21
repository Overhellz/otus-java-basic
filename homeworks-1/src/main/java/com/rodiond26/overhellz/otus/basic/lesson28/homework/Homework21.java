package com.rodiond26.overhellz.otus.basic.lesson28.homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

public class Homework21 {

    private final Object monitor = new Object();
    private String str = "";

    public static void main(String[] args) {
        Homework21 app = new Homework21();
        int count = 5;
        int nThreads = 3;

        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < count; i++) {
            executorService.execute(() -> app.print("A", app.conditionToPrintA()));
            executorService.execute(() -> app.print("B", app.conditionToPrintB()));
            executorService.execute(() -> app.print("C", app.conditionToPrintC()));
        }
        executorService.shutdown();
    }

    public void print(String val, Predicate<String> predicate) {
        synchronized (monitor) {
            try {
                while (predicate.test(str)) {
                    monitor.wait();
                }
                str = val;
                System.out.print(str);
                monitor.notifyAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    Predicate<String> conditionToPrintA() {
        return str -> str != null && !str.isEmpty() && !str.equals("C");
    }

    Predicate<String> conditionToPrintB() {
        return str -> !str.equals("A");
    }

    Predicate<String> conditionToPrintC() {
        return str -> !str.equals("B");
    }
}
