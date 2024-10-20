package com.rodiond26.overhellz.otus.basic.lesson28.lection;

/**
 * Вызов статического синхронизированного метода в разных потоках и синхронизированного объектного метода
 */
public class Example5 {

    /**
     * В методе main() создаются и запускаются три потока:
     * Первый и второй потоки вызывают статический синхронизированный метод classMethod1().
     * Третий поток вызывает синхронизированный объектный метод objMethod1() на экземпляре класса Main.
     * <p>
     * Вывод: Статические методы выполняются последовательно, если вызываются в разных потоках,
     * а объектные методы могут выполняться параллельно со статическими, если синхронизация происходит на разных уровнях.
     */
    public static void main(String[] args) {
        new Thread(() -> classMethod1()).start();
        new Thread(() -> classMethod1()).start();
        Example5 main1 = new Example5();
        new Thread(() -> main1.objMethod1()).start();
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

    /**
     * Метод objMethod1 синхронизированный объектный метод. Он синхронизирован на уровне объекта,
     * т.е. каждый объект Main имеет свой собственный монитор для синхронизации.
     * Если один поток выполняет этот метод на экземпляре объекта Main, другие потоки,
     * которые пытаются выполнить синхронизированные методы на этом же объекте, будут заблокированы,
     * но другие объекты класса могут выполнять его параллельно.
     */
    public synchronized void objMethod1() {
        System.out.println(Thread.currentThread().getName() + " Syn objMethod1() started");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " Syn objMethod1() ended");
    }
}
