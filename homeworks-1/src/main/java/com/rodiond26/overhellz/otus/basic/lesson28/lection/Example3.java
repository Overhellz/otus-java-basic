package com.rodiond26.overhellz.otus.basic.lesson28.lection;

/**
 * Вызов в двух потоках у одного объекта синхронизированного и не синхронизированного методов
 */
public class Example3 {

    /**
     * Метод main запускает в двух потоках у одного объекта синхронизированный и обычный метод
     * <p>
     * Вывод: Методы будут выполняться параллельно, так как блокировка на несинхронизированные методы не распространяется.
     */
    public static void main(String[] args) {
        Example3 main1 = new Example3();
        new Thread(() -> main1.method1()).start();
        new Thread(() -> main1.method3()).start();
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

    /**
     * Метод method3 не синхронизирован
     */
    public void method3() {
        System.out.println(Thread.currentThread().getName() + " method3() started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " method3() ended");
    }
}
