package com.rodiond26.overhellz.otus.basic.utils;

/**
 * Класс для вывода сообщений в консоль
 */
public final class ConsolePrinter {

    private ConsolePrinter() {
    }

    /**
     * Печатает в консоль message
     */
    public static void log(Object obj) {
        System.out.println(obj);
    }

    /**
     * Печатает в консоль message
     */
    public static void logError(String message) {
        System.out.println("* " + message);
    }
}
