package com.rodiond26.overhellz.otus.basic.lesson14.homework;

import com.rodiond26.overhellz.otus.basic.lesson14.homework.exception.AppArrayDataException;
import com.rodiond26.overhellz.otus.basic.lesson14.homework.exception.AppArrayNullException;
import com.rodiond26.overhellz.otus.basic.lesson14.homework.exception.AppArraySizeException;

import java.util.Arrays;

import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.logError;

public class ArrayUtil {

    public int sumOfArray4x4(String[][] arr) {
        return sumOfArray(arr, 4, 4);
    }

    public int sumOfArray(String[][] arr, int length, int height) {
        checkIsNull(arr);
        check2DArrayLength(arr, length);

        int sum = 0;
        for (String[] strArray : arr) {
            check1DArrayLength(strArray, height);
            for (String str : strArray) {
                sum += toInt(str);
            }
        }
        return sum;
    }

    public void checkIsNull(Object obj) {
        if (obj == null) {
            logError("Неккоректный объект: <null>");
            throw new AppArrayNullException("Передан объект со значеним null");
        }
    }

    public void check2DArrayLength(String[][] arr, int length) {
        checkIsNull(arr);
        if (arr.length != length) {
            logError("Неккоректный размер 2d-массива: " + Arrays.deepToString(arr));
            throw new AppArraySizeException("Передан массив с некорректным значеним длины: " + arr.length);
        }
    }

    public void check1DArrayLength(String[] arr, int length) {
        checkIsNull(arr);
        if (arr.length != length) {
            logError("Неккоректный размер 1d-массива: " + Arrays.deepToString(arr));
            throw new AppArraySizeException("Передан массив с некорректным значеним длины: " + arr.length);
        }
    }

    public int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            logError(String.format("Не удалось преобразовать значение [%s] в целое число", str));
            throw new AppArrayDataException("Ошибка при преобразовании строки в число: " + str);
        }
    }
}
