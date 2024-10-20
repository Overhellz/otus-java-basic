package com.rodiond26.overhellz.otus.basic.lesson28.lection;

/**
 * Вызов одного синхронизированного статического метода в разных потоках
 */
public class Example4 {

    /**
     * В методе main() создаются два потока, каждый из которых вызывает статический метод classMethod1().
     * <p>
     * Вывод: Так как метод синхронизирован и работает на уровне класса, оба потока выполнят метод последовательно.
     * Синхронизация на уровне класса позволяет гарантировать, что статический метод будет выполняться только одним
     * потоком за раз, даже если он вызывается в нескольких потоках.
     */
    public static void main(String[] args) {
        new Thread(() -> classMethod1()).start();
        new Thread(() -> classMethod1()).start();
    }

    /**
     * Метод classMethod1() - статический синхронизированный метод класса
     * объявлен как static synchronized, что означает, что он синхронизирован на уровне класса (не объекта),
     * и только один поток может одновременно выполнять этот метод для данного класса.
     */
    public static synchronized void classMethod1() {
        System.out.println(Thread.currentThread().getName() + " Syn static method1: Start");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " Syn static method1: End");
    }
}
