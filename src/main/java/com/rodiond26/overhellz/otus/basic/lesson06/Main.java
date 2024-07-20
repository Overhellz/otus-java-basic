package com.rodiond26.overhellz.otus.basic.lesson06;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        int[] arr = { -1, -2, 5,- 9,- 3,- 7};
//        max(arr);
//        min(arr);
//        wordGuessPlay();
//        magicField();

        Basket basket = new Basket();
        basket.add("фонарик");
        basket.add("фонарик");
        basket.add("фонарик");
        basket.add("фонарик");
        basket.add("фонарик");
        basket.add("бутерброд");
        System.out.println("basket.count() = " + basket.count());
        basket.remove("фонарик");
        System.out.println("basket.count() = " + basket.count());
        basket.remove("лопата");
        basket.add("бутерброд");
        basket.print();
    }

    private static void magicField() {
        String[] fruits = {
                "apple", "plum",
                "kiwi", "pear",
                "pineapple", "grape",
                "strawberry", "cherry",
                "banana", "orange"
        };

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomIndex = random.nextInt(fruits.length);
        String wortToGuess = fruits[randomIndex];
        char[] cache = new char[wortToGuess.length()];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = '*';
        }

        boolean win = false;
        while (!win) {
            System.out.println("введите букву: ");
            char latter = scanner.next().charAt(0);
            char[] wortToGuessChars = wortToGuess.toCharArray();
            System.out.println("слово: ");
            for (int i = 0; i < wortToGuessChars.length; i++) {
                if (wortToGuessChars[i] == latter) {
                    cache[i] = latter;
                }
            }
            for (int i = 0; i < cache.length; i++) {
                System.out.print(cache[i]);
            }
            System.out.println();

            if (checkPoint(cache)) {
                win = true;
            }
        }
    }

    /**
     * @param cache массив с угаданными и неугаданными символами
     * @return есть ли '*'
     * @apiNote метод возращает флаг наличия '*' в кэшируемом массиве
     */
    private static boolean checkPoint(char[] cache) {
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] == '*') {
                return false;
            }
        }
        return true;
    }

    private static void wordGuessPlay() {
        String[] fruits = {
                "apple", "plum",
                "kiwi", "pear",
                "pineapple", "grape",
                "strawberry", "cherry",
                "banana", "orange"
        };

        Scanner scanner = new Scanner(System.in);
        int randomIndex = (int) (Math.random() * fruits.length);
        String wortToGuess = fruits[randomIndex];
        boolean win = false;
        System.out.println("Игра угадай слово, сколько попыток дать? ");
        int k = scanner.nextInt();
        System.out.println("Начнем игру, введите слово:");

        for (int j = 0; j < k; j++) {
            String inputFruit = scanner.next();
            char[] wortToGuessChars = wortToGuess.toCharArray();
            char[] inputFruitChars = inputFruit.toCharArray();

            for (int i = 0; i < wortToGuessChars.length && i < inputFruitChars.length; i++) {
                if (wortToGuessChars[i] == inputFruitChars[i]) {
                    System.out.print(inputFruitChars[i]);
                } else {
                    System.out.print("*");
                }
            }

            int minLength = Math.min(wortToGuessChars.length, inputFruitChars.length);
            for (int i = 0; i < (10 - minLength); i++) {
                System.out.print("*");
            }
            System.out.println();

            if (wortToGuess.equals(inputFruit)) {
                win = true;
                break;
            } else {
                System.out.println("Не угадали, попробуйте ещё : ");
            }
        }

        if (win) {
            System.out.println("Вы победили!");
        } else {
            System.out.println("Вы проиграли!");
        }
    }

    private static void max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("max = " + max);
    }

    private static void min(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("min = " + min);
    }
}
