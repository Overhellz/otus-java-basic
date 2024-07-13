package com.rodiond26.overhellz.otus.basic.lesson05;

public class Homework02 {

    /**
     * Метод печатает в консоль str строку count раз
     */
    public static void printStringCountTimes(int count, String str) {
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                System.out.println(str);
            }
        }
    }

    /**
     * Метод печатает в консоль сумму всех элементов массива intArray, которые больше 5
     */
    public static void printArraySum(int[] intArray) {
        int sum = sumArrayIf(intArray, 5);
        System.out.println(sum);
    }

    /**
     * Метод возвращает сумму всех элементов массива intArray, которые больше value
     */
    public static int sumArrayIf(int[] intArray, int value) {
        int sum = 0;

        if (intArray != null) {
            for (int elem : intArray) {
                if (elem > value) {
                    sum += elem;
                }
            }
        }
        return sum;
    }

    /**
     * Метод принимает массив intArray и заполняет его числом newValue
     */
    public static void fillArray(int newValue, int[] intArray) {
        if (intArray != null) {
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = newValue;
            }
        }
    }

    /**
     * Метод принимает массив intArray и увеличивает каждый его элемент на delta
     */
    public static void addValueToArrayElements(int delta, int[] intArray) {
        if (intArray != null) {
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] += delta;
            }
        }
    }

    /**
     * Метод печатает в консоль сумму элементов левой или правой половины массива intArray в зависимости от того, которая больше
     */
    public static void printGreaterHalfArraySum(int[] intArray) {
        if (intArray == null || intArray.length == 0) {
            System.out.println(0);
            return;
        }

        int sumLeft = sumArrayInRange(intArray, 0, intArray.length / 2);
        int sumRight = sumArrayInRange(intArray, intArray.length / 2, intArray.length);

        System.out.println(Math.max(sumLeft, sumRight));
    }

    /**
     * Метод возвращает сумму элементов массива intArray от элемента с индексом startIndex до элемента с индексом endIndex
     */
    public static int sumArrayInRange(int[] intArray, int startIndex, int endIndex) {
        int sum = 0;
        System.out.println("startIndex: " + startIndex);
        System.out.println("endIndex: " + endIndex);

        if (intArray != null) {
            for (int i = startIndex; i >= 0 && i < intArray.length; i++) {
                sum += intArray[i];
            }
        }
        return sum;
    }
}
