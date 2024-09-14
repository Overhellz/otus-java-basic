package com.rodiond26.overhellz.otus.basic.lesson19.homework;

import java.util.Scanner;

public class Homework12 {
    /**
     * Описание/Пошаговая инструкция выполнения домашнего задания:
     *
     * При старте приложения, в консоль выводится список текстовых файлов из корневого каталоге проекта
     * Далее программа запрашивает имя файла, с которым хочет работать пользователь
     * Содержимое файла выводится в консоль
     * Затем любую введенную пользователем строку необходимо записывать в указанный файл
     */

    public static void main(String[] args) {

        FileEditor fileEditor = new FileEditor();

        System.out.println(">>>>>>> Список файлов:");
        fileEditor.printFileList(".");

        System.out.println(">>>>>>> Введите имя файла:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine().trim();

        System.out.println(">>>>>>> Открывается файл " + fileName);





    }
}
