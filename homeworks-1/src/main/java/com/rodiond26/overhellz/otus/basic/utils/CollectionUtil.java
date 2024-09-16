package com.rodiond26.overhellz.otus.basic.utils;

import java.util.List;

/**
 * Класс для работы с коллекциями
 */
public final class CollectionUtil {

    private CollectionUtil() {
    }

    /**
     * Возвращает true, если список равен null или список пуст
     */
    public static <T> boolean isEmpty(List<T> list) {
        return list == null || list.isEmpty();
    }

    /**
     * Возвращает true,
     * если значение строки равна null,
     * или если строка пуста,
     * или если строка содержит только пробельные символы
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
