package com.rodiond26.overhellz.otus.basic.lesson28.lection;

/**
 * Вызов в двух потоках у одного объекта синхронизированного метода
 */
public class Example1 {

    /**
     * Метод main запускает два потока, каждый из которых вызывает метод method1 объекта main1.
     * Потоки создаются с использованием лямбда-выражений и запускаются с помощью метода start().
     * <p>
     * Вывод: если два потока у одного объекта main1 вызывают один и тот же синхронизированный метод .method1(),
     * то такое выполнение будет последовательным.
     */
    public static void main(String[] args) {
        Example1 main1 = new Example1();
        new Thread(() -> main1.method1()).start(); // или через ссылку на метод: new Thread(main1::method1).start();
        new Thread(() -> main1.method1()).start();
    }

    /**
     * Метод method1 объявлен с ключевым словом synchronized, что означает, что только один поток может выполнять его
     * для данного объекта main1.
     * Другие потоки, пытающиеся выполнить метод method1, будут ждать, пока первый поток не завершит выполнение этого метода.
     */
    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " method1() started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " method1() ended");
    }
}
