package com.rodiond26.overhellz.otus.basic.lesson28.lection;

/**
 * Вызов в двух потоках у одного объекта разных синхронизированных методов
 */
public class Example2 {

    /**
     * Метод main запускает в двух потоках у одного объекта разные синхронизированные методы
     * <p>
     * Вывод: если два потока у одного объекта main1 вызывают разные синхронизированные методы .method1() и .method2()
     * то такое выполнение будет последовательным, потому что ключевое слово synchronized в Java накладывает блокировку
     * (монитор) на объект, а не на конкретный метод.
     */
    public static void main(String[] args) {
        Example2 main1 = new Example2();
        new Thread(() -> main1.method1()).start();
        new Thread(() -> main1.method2()).start();
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
     * Метод method2 объявлен с ключевым словом synchronized
     */
    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " method2() started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " method2() ended");
    }
}
