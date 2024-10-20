package com.rodiond26.overhellz.otus.basic.lesson28.lection;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Пример использования пула потоков через ExecutorService для выполнения задач
 * и его немедленное завершение с помощью метода .shutdownNow()
 */
public class Example10 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 150; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        List<Runnable> uncompletedTasks = executorService.shutdownNow(); // Немедленно остановить пул потоков
        System.out.println(uncompletedTasks); // список не выполненных задач
    }
}
