package com.rodiond26.overhellz.otus.basic.lesson28.lection;

/**
 * Пример правильной остановки потока с использованием переменной-флага
 */
public class Example8 {

    /**
     * Переменная объявлена как volatile, это гарантирует то, что изменения переменной running, сделанные в одном потоке,
     * сразу становятся видимыми другим потокам
     */
    private static volatile boolean running = true; // Общий флаг для управления потоком

    public static void main(String[] args) {

        Thread thread = new Thread(() -> { // Создаем поток
            while (running) {
                System.out.println("Поток работает...");
                try {
                    Thread.sleep(1000); // Симуляция работы
                } catch (InterruptedException e) {
                    // Обрабатываем прерывание сна
                    // Thread.currentThread().interrupt(); здесь уже не восстанавливаем статус прерывания, так как не используем .interrupt()
                    e.printStackTrace();
                }
            }
            System.out.println("Поток остановлен");
        });

        thread.start();

        try {
            Thread.sleep(3000);  // Даем потоку поработать 3 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Остановка потока...");
        running = false;  // Изменяем флаг, чтобы остановить поток
    }
}
