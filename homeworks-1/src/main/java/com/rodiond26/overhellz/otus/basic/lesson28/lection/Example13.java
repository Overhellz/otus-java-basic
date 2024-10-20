package com.rodiond26.overhellz.otus.basic.lesson28.lection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Пример использования метода .awaitTermination() (аналог ".join() в пуле потоков")
 */
public class Example13 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 150; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        executorService.shutdown();
        // аналог .join
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished");
    }
}
