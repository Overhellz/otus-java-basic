package com.rodiond26.overhellz.otus.basic.lesson07;

import com.rodiond26.overhellz.otus.basic.lesson05.Homework02;

public class Homework03 {

    /**
     * Метод принимает целочисленный двумерный массив и возвращает сумму всех элементов массива, которые больше 0
     */
    public static int sumOfPositiveElements(int[][] arrays) {
        return arrays == null ? 0 : sumArrayIf(arrays, 0);
    }

    /**
     * Метод возвращает сумму всех элементов двумерного массива arrays, которые больше value
     */
    public static int sumArrayIf(int[][] arrays, int value) {
        if (arrays == null) {
            return 0;
        }

        int sum = 0;
        for (int[] array : arrays) {
            sum += Homework02.sumArrayIf(array, value);
        }
        return sum;
    }

    /**
     * Метод принимает size и печатает в консоль квадрат из символов * со сторонами длиной size
     */
    public static void printAsteriskSquare(int size) {
        printConsoleSquare(size, '*', ' ');
    }

    /**
     * Метод печатает в консоль квадрат, заполненный символами borderSymbol и innerSymbol, со сторонами длиной size
     *
     * @param size         длина стороны квадрата
     * @param borderSymbol символ заполнения границ квадрата
     * @param innerSymbol  символ заполнения между границами квадрата
     */
    public static void printConsoleSquare(int size, char borderSymbol, char innerSymbol) {
        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size - 1) {
                System.out.println(createSquareBorder(size, borderSymbol, borderSymbol));
            } else {
                System.out.println(createSquareBorder(size, borderSymbol, innerSymbol));
            }
        }
    }

    /**
     * Метод возвращает строку длиной size, заполненную символами borderSymbol и innerSymbol
     *
     * @param size         длина строки
     * @param borderSymbol символ заполнения границ
     * @param innerSymbol  символ заполнения между границами
     * @return строка для вывода квадрата
     */
    public static String createSquareBorder(int size, char borderSymbol, char innerSymbol) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size - 1) {
                sb.append(borderSymbol);
            } else {
                sb.append(innerSymbol);
            }
        }

        return sb.toString();
    }

    /**
     * Метод принимает двумерный целочисленный массив и зануляюет его диагональные элементы
     */
    public static void fillDiagonalElementsByZero(int[][] arrays) {
        // Считаем, что к нам приходит массив с равным количеством строк и столбцов
        fillDiagonalElementsByNewValue(arrays, 0);
    }

    /**
     * Метод принимает двумерный целочисленный массив и заполняет его диагональные элементы значением newValue
     */
    public static void fillDiagonalElementsByNewValue(int[][] arrays, int newValue) {
        if (arrays == null) {
            return;
        }

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (i == j) {
                    arrays[i][j] = newValue;
                    continue;
                }

                if (i == arrays[i].length - 1 - j) {
                    arrays[i][j] = newValue;
                }
            }
        }
    }

    /**
     * Метод принимает двумерный целочисленный массив arrays и возвращает максимальное значение элемента массива или null
     */
    public static Integer findNullableMax(int[][] arrays) {
        if (arrays == null) {
            return null;
        }

        Integer max = null;
        for (int[] array : arrays) {
            for (int element : array) {
                max = nullableMax(max, element);
            }
        }

        return max;
    }

    /**
     * Метод возвращает возвращает максимальное значение элемента массива или null
     */
    public static Integer findNullableMax(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        int max = array[0];
        for (int element : array) {
            max = Math.max(max, element);
        }

        return max;
    }

    /**
     * Метод возвращает большее значение среди двух элементов или null
     */
    public static Integer nullableMax(Integer first, Integer second) {
        if (first == null && second == null) {
            return null;
        }
        if (first != null && second == null) {
            return first;
        }
        if (first == null && second != null) {
            return second;
        }
        return Math.max(first, second);
    }

    /**
     * Метод возвращает сумму элементов второй строки двумерного массива
     * <p>Если второй строки не существует, то метод возвращает -1</p>
     */
    public static int secondStringSum(int[][] arrays) {
        int defaultValue = -1;

        if (arrays == null || arrays.length <= 1) {
            return defaultValue;
        }

        Integer sum = nullableSum(arrays[1]);
        return sum == null ? defaultValue : sum;
    }

    /**
     * Метод возвращает возвращает сумму значений элементов массива или null
     */
    public static Integer nullableSum(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        int sum = 0;
        for (int element : array) {
            sum += element;
        }

        return sum;
    }
}
