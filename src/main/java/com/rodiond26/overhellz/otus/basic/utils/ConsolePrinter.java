package com.rodiond26.overhellz.otus.basic.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Класс для вывода сообщений в консоль
 */
public final class ConsolePrinter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private ConsolePrinter() {
    }

    /**
     * Возвращает строку в формате json из объекта object,
     * иначе возвращает результат метода toString
     */
    public static String toJsonOrToString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log("Не удалось сериализовать объект в json: " + object);
            return String.valueOf(object);
        }
    }

    /**
     * Печатает в консоль message
     */
    public static void log(String message) {
        System.out.println(message);
    }

    /**
     * Печатает в консоль message
     */
    public static void logError(String message) {
        System.out.println("* " + message);
    }
}
