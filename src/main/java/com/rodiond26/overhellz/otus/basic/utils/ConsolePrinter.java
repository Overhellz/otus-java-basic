package com.rodiond26.overhellz.otus.basic.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Класс для вывода сообщений в консоль
 */
public final class ConsolePrinter {

    private ConsolePrinter() {
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
