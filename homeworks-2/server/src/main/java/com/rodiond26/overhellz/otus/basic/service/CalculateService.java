package com.rodiond26.overhellz.otus.basic.service;

public class CalculateService {

    /**
     * Принимает и разбирает строку message и возвращает результат вычисления,
     * иначе выбрасывает исключение
     *
     * @param message строка, которая содержит два числа и операцию между ними через пробел
     * @return результат вычисления или исключение
     */
    public double calculateExpressionOrThrow(String message) {
        try {
            String[] str = message.split(" ");
            double first = Double.parseDouble(str[0]);
            double second = Double.parseDouble(str[1]);
            String operation = str[2];

            return calculate(first, second, operation);
        } catch (Exception e) {
            System.err.println();
            throw new RuntimeException(); // TODO fix;
        }
    }

    private double calculate(double first, double second, String operation) {
        return switch (operation) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> {
                if (isZero(second)) {
                    throw new RuntimeException(); // TODO fix
                }
                yield first / second;
            }
            default -> throw new RuntimeException(); // TODO fix;
        };
    }

    /**
     * Возращает true, если значение value равно нулю,
     * иначе возвращает false
     */
    private boolean isZero(double value) {
        double epsilon = 0.0000001d;
        return Math.abs(value) < epsilon;
    }
}
