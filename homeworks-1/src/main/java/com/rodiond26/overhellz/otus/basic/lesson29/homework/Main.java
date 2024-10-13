package com.rodiond26.overhellz.otus.basic.lesson29.homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.debug("Старт приложения");
        ArrayUtils util = new ArrayUtils();

        int[] arr1 = {1, 2, 1, 2, 2};
        int val1 = 1;
        int index1 = util.getLastIndexOfValueInArray(arr1, val1);
        int[] resultArray1 = util.getArrayAfterLastValueOrThrow(arr1, val1);
        LOGGER.info("Индекс последнего значения {} равен {}", val1, index1); // 2
        LOGGER.info("Новый массив = {}", resultArray1); // [2, 2]

        int[] arr2 = {2, 2, 2, 2};
        int val2 = 1;
        int index2 = util.getLastIndexOfValueInArray(arr2, val2);
        LOGGER.info("Индекс последнего значения {} равен {}", val2, index2); // -1

        int[] resultArray2;
        try {
            resultArray2 = util.getArrayAfterLastValueOrThrow(arr2, val2);
            LOGGER.info("Индекс последнего значения {} равен {}", val2, index2); // -1
            LOGGER.info("Новый массив = {}", resultArray2); // [2, 2]
        } catch (RuntimeException e) {
            LOGGER.error("Произошла ошибка при работе с массивом arr2 = {}", e.getMessage());
        }

        LOGGER.debug("Стоп приложения");
    }
}
