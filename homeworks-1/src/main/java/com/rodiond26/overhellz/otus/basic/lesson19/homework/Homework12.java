package com.rodiond26.overhellz.otus.basic.lesson19.homework;

public class Homework12 {

    public static void main(String[] args) {

        FileEditor fileEditor = new FileEditor();

        System.out.println(">>>>>>> Список файлов:");
        fileEditor.printFileList(".");

        System.out.println(">>>>>>> Введите имя файла:");
        String fileName = fileEditor.getUserFile();

        System.out.println(">>>>>>> Открывается файл: " + fileName);
        boolean isFileExist = fileEditor.readAndPrint(fileName);
        System.out.println("<<<<<<<");

        if (isFileExist) {
            System.out.println(">>>>>>> Дописать в файл строку:");
            fileEditor.write(fileName);
        }
    }
}
