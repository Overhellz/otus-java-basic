package com.rodiond26.overhellz.otus.basic.service;

public final class ServerMessage {

    private ServerMessage() {
    }

    public static final String START_MESSAGE = """
            Клиент-серверное приложение "Калькулятор".
            Доступные математические операции:
            [+] Сложение
            [-] Вычитание
            [*] Умножение
            [/] Деление
            Введите два числа и операцию между ними через пробел:
            """;
}
