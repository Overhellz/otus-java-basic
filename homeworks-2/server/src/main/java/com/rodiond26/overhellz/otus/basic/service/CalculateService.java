package com.rodiond26.overhellz.otus.basic.service;

public class CalculateService {

    /**
     * Принимает и разбирает строку expression и возвращает результат вычисления,
     * иначе выбрасывает исключение
     *
     * @param expression строка, которая содержит два числа и операцию между ними через пробел
     * @return результат вычисления или исключение
     */
    public double calculateExpressionOrThrow(String expression) {
        try {
            String[] str = expression.split(" ");
            double first = Double.parseDouble(str[0]);
            double second = Double.parseDouble(str[1]);
            String operation = str[2];

            return calculate(first, second, operation);
        } catch (Exception e) {
            System.err.println("Некорректное выражение: " + expression);
            throw new RuntimeException("Некорректное выражение");
        }
    }

    private double calculate(double first, double second, String operation) {
        return switch (operation) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> {
                if (isZero(second)) {
                    System.err.println("Делитель равен нулю: " + second);
                    throw new RuntimeException("Деление на ноль");
                }
                yield first / second;
            }
            default -> throw new RuntimeException("Некорректная операция: " + operation);
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
