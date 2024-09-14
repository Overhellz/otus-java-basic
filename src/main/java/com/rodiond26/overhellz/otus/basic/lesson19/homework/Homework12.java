package com.rodiond26.overhellz.otus.basic.lesson19.homework;

import java.util.Scanner;

public class Homework12 {

    public static void main(String[] args) {

        FileEditor fileEditor = new FileEditor();

        System.out.println(">>>>>>> Список файлов:");
        fileEditor.printFileList(".");

        System.out.println(">>>>>>> Введите имя файла:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine().trim();

        System.out.println(">>>>>>> Открывается файл " + fileName);
        fileEditor.readAndPrint(fileName);
        System.out.println("<<<<<<<");

        System.out.println(">>>>>>> Дописать в файл строку:");
        fileEditor.write(fileName);
    }
}
