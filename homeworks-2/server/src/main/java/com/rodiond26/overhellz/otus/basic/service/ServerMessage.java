package com.rodiond26.overhellz.otus.basic.service;

public final class ServerMessage {

    private ServerMessage() {
    }

    public static final String START_MESSAGE = """
            Доступные математические операции:
            [+] Сложение
            [-] Вычитание
            [*] Умножение
            [/] Деление
            [<exit>] Выход
            Введите два числа и операцию между ними через пробел:
            """;
}
