package com.rodiond26.overhellz.otus.basic.lesson03;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {

        consoleGreeting();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ввод: ");
        int userInput = scanner.nextInt();

        mainProgram(userInput);
    }

    public static void consoleGreeting() {
        System.out.println("Выберите метод (1-5), в ином случае произойдет выход из программы:");
        System.out.println("1 - greetings");
        System.out.println("2 - checkSign");
        System.out.println("3 - selectColor");
        System.out.println("4 - compareNumbers");
        System.out.println("5 - addOrSubtractAndPrint");
    }

    public static void mainProgram(int userInput) {
        switch (userInput) {
            case 1:
                greetings();
                break;
            case 2:
                int a = randomInt(10);
                int b = randomInt(10);
                int c = randomInt(10);
                System.out.println("a=" + a);
                System.out.println("b=" + b);
                System.out.println("c=" + c);
                checkSign(a, b, c);
                break;
            case 3:
                selectColor();
                break;
            case 4:
                compareNumbers();
                break;
            case 5:
                int initValue = randomInt(10);
                int delta = randomInt(10);
                boolean increment = randomBoolean();
                System.out.println("initValue=" + initValue);
                System.out.println("delta=" + delta);
                System.out.println("increment=" + increment);
                addOrSubtractAndPrint(initValue, delta, increment);
                break;
            default:
                System.out.println("Выход");
                break;
        }
    }

    public static void greetings() {
        System.out.print("Hello\nWorld\nfrom\nJava\n");
    }

    public static void checkSign(int a, int b, int c) {
        if (a + b + c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = 5;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = randomInt(10);
        int b = randomInt(10);
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        if (a >= b) {
            System.out.println("a >= b");
        } else
            System.out.println("a < b");
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }

    /**
     * Возвращает случайное целое число в диапазоне от -number до +number
     */
    public static int randomInt(int number) {
        return (int) (Math.random() * (2 * number) - number);
    }

    /**
     * Возвращает случайное булево значение
     */
    public static boolean randomBoolean() {
        return Math.random() > 0.5;
    }
}
