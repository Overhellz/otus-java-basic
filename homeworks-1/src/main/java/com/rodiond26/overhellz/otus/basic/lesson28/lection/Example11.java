package com.rodiond26.overhellz.otus.basic.lesson28.lection;

import java.util.concurrent.*;

/**
 * Пример использования Callable и возврат результата задачи
 * через пул потоков ExecutorService и интерфейс Future
 * и блокирующий метод .get()
 */
public class Example11 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("Starting thread");
        // Так же можно писать через лямбду, но добавить return
        // Future future = executorService.submit(() -> { ... return ...}
        Future future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "Hello World!";
            }
        });
        System.out.println(future.get()); // Hello World!
        System.out.println("Finished thread");
        executorService.shutdownNow();
    }
}
