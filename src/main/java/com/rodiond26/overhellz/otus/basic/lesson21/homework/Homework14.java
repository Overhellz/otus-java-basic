package com.rodiond26.overhellz.otus.basic.lesson21.homework;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Homework14 {

    public static void main(String[] args) {
        implementation1(); // 10272188300 nanos
        implementation2(); //  2913237000 nanos
    }

    /**
     * Реализация заполнения массива №1 - в один поток
     */
    public static void implementation1() {
        double[] array = new double[100_000_000];

        long startTime = System.nanoTime();
        fillArray(array, 0, array.length);
        long endTime = System.nanoTime();

        System.out.printf("Время выполнения: %d нс\n", endTime - startTime);
    }

    /**
     * Реализация заполнения массива №2 - в четыре потока
     */
    public static void implementation2() {
        double[] array = new double[100_000_000];

        Thread t1 = new Thread(() -> fillArray(array, 0, 25_000_000));
        Thread t2 = new Thread(() -> fillArray(array, 25_000_000, 50_000_000));
        Thread t3 = new Thread(() -> fillArray(array, 50_000_000, 75_000_000));
        Thread t4 = new Thread(() -> fillArray(array, 75_000_000, array.length));

        long startTime = System.nanoTime();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.nanoTime();

        System.out.printf("Время выполнения: %d нс\n", endTime - startTime);
    }

    /**
     * Заполнение массива от fromIndex индекса до toIndex индекса
     */
    public static void fillArray(double[] array, int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex < 0 || fromIndex > toIndex) {
            throw new IllegalArgumentException(String.format("Неверное значение параметров: from=%d, to=%d ", fromIndex, toIndex));
        }

        for (int i = fromIndex; i < toIndex; i++) {
            array[i] = calculate(i);
        }
    }

    /**
     * Возвращает значение элемента массива в зависимости от его индекса
     */
    public static double calculate(int i) {
        return 1.14 * cos(i) * sin(i * 0.2) * cos(i / 1.2);
    }
}
