package com.rodiond26.overhellz.otus.basic.lesson29.homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ArrayUtils {

    public static final int NO_VALUE_IN_ARRAY_CODE = -1;
    private static final Logger LOGGER = LogManager.getLogger(ArrayUtils.class.getName());

    public ArrayUtils() {
    }

    /**
     * Возвращает новый массив из исходного массива arr последнего значения val в массиве,
     * иначе выбрасывает исключение
     *
     * @param arr исходный массив
     * @param val последнее значение в исходном массиве
     */
    public int[] getArrayAfterLastValueOrThrow(int[] arr, int val) {
        int lastIndexOfValue = getLastIndexOfValueInArray(arr, val);
        if (lastIndexOfValue == NO_VALUE_IN_ARRAY_CODE) {
            LOGGER.error("Массив не содержит элементов со значением = {}", val);
            throw new RuntimeException("Массив не содержит элементов с заданным значением");
        }

        int newArrayLength = arr.length - lastIndexOfValue - 1;
        int[] resultArray = new int[newArrayLength];
        for (int i = lastIndexOfValue + 1, j = 0; i < arr.length; i++, j++) {
            resultArray[j] = arr[i];
        }
        return resultArray;
    }

    /**
     * Возвращает индекс последнего значения val в массиве arr
     *
     * @param arr исходный массив
     * @param val последнее значение в исходном массиве
     * @return индекс последнего значения val в массиве arr
     */
    public int getLastIndexOfValueInArray(int[] arr, int val) {
        if (arr == null || arr.length == 0) {
            return NO_VALUE_IN_ARRAY_CODE;
        }

        int lastIndex = NO_VALUE_IN_ARRAY_CODE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    /**
     * Возвращает true, если массив arr содержит только значения и хотя бы по одному значению first и second,
     * иначе возвращает false
     */
    public boolean isContainOnlyValues(int[] arr, int first, int second) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        boolean hasFirst = false;
        boolean hasSecond = false;
        for (int val : arr) {
            if (val != first && val != second) {
                return false;
            }
            if (val == first) {
                hasFirst = true;
                continue;
            }
            hasSecond = true;
        }
        return hasFirst && hasSecond;
    }
}
