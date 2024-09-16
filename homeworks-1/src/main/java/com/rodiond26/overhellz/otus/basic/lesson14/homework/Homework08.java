package com.rodiond26.overhellz.otus.basic.lesson14.homework;

import com.rodiond26.overhellz.otus.basic.lesson14.homework.exception.AppArrayDataException;
import com.rodiond26.overhellz.otus.basic.lesson14.homework.exception.AppArrayNullException;
import com.rodiond26.overhellz.otus.basic.lesson14.homework.exception.AppArraySizeException;

import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

public class Homework08 {

    public static void main(String[] args) {
        ArrayUtil util = new ArrayUtil();
        String[][] arr1 = null;

        try {
            util.sumOfArray4x4(arr1);
        } catch (AppArrayNullException e) {
            log("Поймали исключение " + e.getClass().getSimpleName());
        }

        String[][] arr2 = {{}, {}, {}};
        try {
            util.sumOfArray4x4(arr2);
        } catch (AppArraySizeException e) {
            log("Поймали исключение " + e.getClass().getSimpleName());
        }

        String[][] arr3 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3"}
        };
        try {
            util.sumOfArray4x4(arr3);
        } catch (AppArraySizeException e) {
            log("Поймали исключение " + e.getClass().getSimpleName());
        }

        String[][] arr4 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "a"}
        };
        try {
            util.sumOfArray4x4(arr4);
        } catch (AppArrayDataException e) {
            log("Поймали исключение " + e.getClass().getSimpleName());
        }

        String[][] arr5 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", null}
        };
        try {
            util.sumOfArray4x4(arr5);
        } catch (AppArrayDataException e) {
            log("Поймали исключение " + e.getClass().getSimpleName());
        }

        String[][] arr6 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        int sum = 0;
        try {
            sum = util.sumOfArray4x4(arr6);
        } catch (Exception e) {
            log("Поймали исключение " + e.getClass().getSimpleName());
        } finally {
            log("Получили значение суммы элементов корректного масссива: " + sum);
        }
    }
}
