package com.rodiond26.overhellz.otus.basic.lection11.training.task_04;

/**
 * Дана строка, состоящая из слов, разделенных пробелами.
 * Необходимо реализовать метод, который возвращает строку,
 * слова в которой записаны в обратном порядке.
 * Например, для строки "test abc" необходимо получить строку "abc test".
 */

public class WordUtils {

    private WordUtils() {
    }

    public static String reverseWords(String inputText) {
        if (inputText == null || inputText.isBlank()) {
            return "";
        }

        String[] words = inputText.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            result.append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println("Ввод пустой строки - " + WordUtils.reverseWords(""));
        System.out.println("Ввод одного слова - " + WordUtils.reverseWords("word"));
        System.out.println("Ввод двух слов - " + WordUtils.reverseWords("два слова"));
        System.out.println(WordUtils.reverseWords("test abc"));
    }
}
