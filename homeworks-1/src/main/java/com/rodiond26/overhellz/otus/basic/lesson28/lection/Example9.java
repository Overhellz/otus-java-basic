package com.rodiond26.overhellz.otus.basic.lesson28.lection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Пример работы методов isShutdown() и shutdown() при использовании пула потоков с интерфейсом ExecutorService
 */
public class Example9 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(executorService.isShutdown()); // false
        executorService.shutdown();
        System.out.println(executorService.isShutdown()); // true
    }
}
