package com.rodiond26.overhellz.otus.basic.lesson05;

public class Homework02 {

    /**
     * Метод печатает в консоль str строку count раз
     */
    public static void printStringCountTimes(int count, String str) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    /**
     * Метод печатает в консоль сумму всех элементов массива array, которые больше 5
     */
    public static void printArraySum(int[] array) {
        int sum = sumArrayIf(array, 5);
        System.out.println(sum);
    }

    /**
     * Метод возвращает сумму всех элементов массива array, которые больше value
     */
    public static int sumArrayIf(int[] array, int value) {
        int sum = 0;

        if (array != null) {
            for (int elem : array) {
                if (elem > value) {
                    sum += elem;
                }
            }
        }
        return sum;
    }

    /**
     * Метод принимает массив array и заполняет его значением newValue
     */
    public static void fillArray(int newValue, int[] array) {
        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = newValue;
        }
    }

    /**
     * Метод принимает массив array и увеличивает каждый его элемент на delta
     */
    public static void addValueToArrayElements(int delta, int[] array) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                array[i] += delta;
            }
        }
    }

    /**
     * Метод печатает в консоль сумму элементов левой или правой половины массива array в зависимости от того, которая больше
     */
    public static void printGreaterHalfArraySum(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println(0);
            return;
        }

        int sumLeft = sumArrayInRange(array, 0, array.length / 2);
        int sumRight = sumArrayInRange(array, array.length / 2, array.length);

        System.out.println(Math.max(sumLeft, sumRight));
    }

    /**
     * Метод возвращает сумму элементов массива array от элемента с индексом startIndex до элемента с индексом endIndex
     */
    public static int sumArrayInRange(int[] array, int startIndex, int endIndex) {
        int sum = 0;

        if (array != null) {
            for (int i = startIndex; i >= 0 && i < array.length && i < endIndex; i++) {
                sum += array[i];
            }
        }
        return sum;
    }
}
