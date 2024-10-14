package com.rodiond26.overhellz.otus.basic.lesson27.homework;

import com.rodiond26.overhellz.otus.basic.lesson19.homework.FileEditor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.debug("Старт приложения");
        FileEditor fileEditor = new FileEditor();
        TextUtils textUtils = new TextUtils();

        LOGGER.debug("Вывод списка файлов");
        System.out.println(">>>>>>> Список файлов:");
        fileEditor.printFileList(".");

        LOGGER.debug("Запрос имени файла");
        System.out.println(">>>>>>> Введите имя файла и строку для поиска через пробел:");
        String fileName = fileEditor.getUserFile();
        String str = null; // TODO fix

        int count = textUtils.countSubstringInFile(fileName, str);
        System.out.printf(">>>>>>> В файле %s найдена строка '%s' %d раз%n\n", fileName, str, count);

        LOGGER.debug("Стоп приложения");
    }
}
