package ru.otus.october.http.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {
    // Домашнее задание:
    // 1. Избавиться от sout'ов и подключить логгер
    // 2. Сделайте парсинг заголовков запросов в Map<String, String>
    // 3. * Добавьте обработку 405 Method Not Allowed

    private static final Logger LOGGER = LogManager.getLogger(Application.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Старт сервера");
        new HttpServer(8189, 10).start();
        LOGGER.info("Стоп сервера");
    }
}
