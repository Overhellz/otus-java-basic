package com.rodiond26.overhellz.otus.basic.lesson29.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.rodiond26.overhellz.otus.basic.lesson29.homework.ArrayUtils.NO_VALUE_IN_ARRAY_CODE;
import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    private ArrayUtils util;

    @BeforeEach
    void init() {
        util = new ArrayUtils();
    }

    @Test
    @DisplayName("Проверки массива arr, если в нем нет элементов")
    void getLastIndexOfValueInArray_whenArrayIsEmpty() {
        int val = 1;
        assertAll(
                () -> assertEquals(NO_VALUE_IN_ARRAY_CODE, util.getLastIndexOfValueInArray(null, val)),
                () -> assertEquals(NO_VALUE_IN_ARRAY_CODE, util.getLastIndexOfValueInArray(new int[]{}, val))
        );
    }

    @Test
    @DisplayName("Проверка наличия в массиве arr значения val")
    void getLastIndexOfValueInArrayTest() {
        int[] arr = {0, 1, 2, 3, 4, 5};
        int val1 = 1;
        int val3 = 3;

        assertAll(
                () -> assertEquals(val1, util.getLastIndexOfValueInArray(arr, val1)),
                () -> assertEquals(val3, util.getLastIndexOfValueInArray(arr, val3))
        );
    }

    @Test
    @DisplayName("Проверка, что массив arr не содержит значение val и выбрасывает исключение при работе")
    void getArrayAfterLastValueOrThrow_whenNoValue() {
        int[] arr = {2, 2, 2, 2};
        int val = 1;

        Exception exception = assertThrows(RuntimeException.class, () -> util.getArrayAfterLastValueOrThrow(arr, val));
        assertEquals(exception.getClass(), RuntimeException.class);
    }

    @Test
    @DisplayName("Проверка, что массив arr содержит значение val и возвращает новый массив")
    void getArrayAfterLastValueOrThrow_whenSuccess() {
        int[] arr = {1, 2, 1, 2, 2};
        int val = 1;
        int[] expectedArray = {2, 2};
        int[] resultArray = util.getArrayAfterLastValueOrThrow(arr, val);

        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    @DisplayName("Проверки массива arr, если в нем меньше двух элементов")
    void isContainOnlyValues_whenArrayIsNotValid() {
        int first = 1;
        int second = 2;
        int[] arr1 = null;
        int[] arr2 = {first};
        int[] arr3 = {second};

        assertAll(
                () -> assertFalse(util.isContainOnlyValues(arr1, first, second)),
                () -> assertFalse(util.isContainOnlyValues(arr2, first, second)),
                () -> assertFalse(util.isContainOnlyValues(arr3, first, second))
        );
    }

    @Test
    @DisplayName("Проверки массива arr, что он содержит корректные значения")
    void isContainOnlyValues() {
        int first = 1;
        int second = 2;
        int[] arr1 = {first, second};
        int[] arr2 = {first, first, second};
        int[] arr3 = {first, second, second};
        int[] arr4 = {first, first, second, second};
        int[] arr5 = {first, second, second, second};
        int[] arr6 = {first, first, first, first, first, second, second, second};

        assertAll(
                () -> assertTrue(util.isContainOnlyValues(arr1, first, second)),
                () -> assertTrue(util.isContainOnlyValues(arr2, first, second)),
                () -> assertTrue(util.isContainOnlyValues(arr3, first, second)),
                () -> assertTrue(util.isContainOnlyValues(arr4, first, second)),
                () -> assertTrue(util.isContainOnlyValues(arr5, first, second)),
                () -> assertTrue(util.isContainOnlyValues(arr6, first, second))
        );
    }

    @ParameterizedTest
    @MethodSource("provideIncorrectArrays")
    @DisplayName("Проверки массива arr, что он содержит некорректные значения")
    void isContainOnlyValues_whenIncorrectValues(int[] arr, int first, int second) {
        assertFalse(util.isContainOnlyValues(arr, first, second));
    }

    static Stream<Arguments> provideIncorrectArrays() {
        int first = 1;
        int second = 2;
        int third = 3;

        return Stream.of(
                Arguments.of(new int[]{first, second, third}, first, second),
                Arguments.of(new int[]{first, third}, first, second),
                Arguments.of(new int[]{second, third}, first, second),
                Arguments.of(new int[]{third}, first, second),
                Arguments.of(new int[]{third, third}, first, second),
                Arguments.of(new int[]{third, third, third}, first, second),
                Arguments.of(new int[]{third, third, third, third, third, third}, first, second),
                Arguments.of(new int[]{first, first}, first, second),
                Arguments.of(new int[]{first, first, first, first}, first, second),
                Arguments.of(new int[]{second, second}, first, second),
                Arguments.of(new int[]{second, second, second}, first, second),
                Arguments.of(new int[]{second, second, second, third}, first, second)
        );
    }
}
