package com.rodiond26.overhellz.otus.basic.lesson04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    }

    public static void calculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        float a = scanner.nextFloat();
        System.out.println("Введите второе число:");
        float b = scanner.nextFloat();
        System.out.println("Введите операцию +, -, *, / :");
        char operation = scanner.next().charAt(0);
        float result;
        if (operation == '+') {
            result = a + b;
        } else if (operation == '-') {
            result = a - b;
        } else if (operation == '*') {
            result = a * b;
        } else if (operation == '/') {
            result = a / b;
        } else {
            System.out.println("Неизвестная операция");
            return;
        }

        System.out.println(a + " " + operation + " " + b + " = " + result);
    }

    public static void hardAiNumber() {
        System.out.println("*** Угадай число ***");
        Scanner scanner = new Scanner(System.in);
        int difficult;
        int triesCount;
        do {
            System.out.println("Выберите сложность игры:\n 1 - легко \n 2 - средне \n 3 - сложно ");
            difficult = scanner.nextInt();
        } while (difficult < 1 || difficult > 3);

        int maxNumber;
        if (difficult == 1) {
            maxNumber = 6;
            triesCount = 3;
        } else if (difficult == 2) {
            maxNumber = 9;
            triesCount = 3;
        } else {
            maxNumber = 15;
            triesCount = 2;
        }

        int aiNumber = (int) (Math.random() * maxNumber) + 1;
        System.out.println("Компьютер загадал число в интервале от 1 до " + maxNumber);
        int answer;

        while (true) {
            do {
                System.out.println("Введите число в интервале от 1 до " + maxNumber);
                answer = scanner.nextInt();
            } while (answer < 1 || answer > maxNumber);

            if (answer == aiNumber) {
                System.out.println("Вы победили!");
                break;
            } else if (answer < aiNumber) {
                System.out.println("Загаданное число больше");
            } else {
                System.out.println("Загаданное число меньше");
            }
            triesCount--;
            System.out.println("Количество оставшихся попыток: " + triesCount);
            if (triesCount == 0) {
                System.out.println("Игра проиграна");
                break;
            }
        }
        System.out.println("Было загадано число " + aiNumber);
    }

    public static void simpleAiNumber() {
        System.out.println("*** Угадай число ***");
        Scanner scanner = new Scanner(System.in);
        int aiNumber = (int) (Math.random() * 9) + 1;
        System.out.println("Компьютер загадал число в интервале от 1 до 9");
        int answer;
        do {
            System.out.println("Введите число в интервале от 1 до 9");
            answer = scanner.nextInt();
        } while (answer < 1 || answer > 9);

        if (answer == aiNumber) {
            System.out.println("Вы победили!");
        } else {
            System.out.println("Вы проиграли!");
        }
        System.out.println("Было загадано число " + aiNumber);
    }

    public static void inputRetry() {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.println("введите число в интервале от 0 до 5");
            n = scanner.nextInt();
        } while (n < 0 || n > 5);
        System.out.println(n);
    }
}
