package com.rodiond26.overhellz.otus.basic.lesson27.homework;

import com.rodiond26.overhellz.otus.basic.lesson19.homework.FileEditor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.Set;

public final class MainScenario {

    private static final Logger LOGGER = LogManager.getLogger(MainScenario.class.getName());

    public MainScenario() {
    }

    public void start() {

        FileEditor fileEditor = new FileEditor();
        TextUtils textUtils = new TextUtils();
        String directoryPath = ".";

        LOGGER.debug("Вывод списка файлов");
        System.out.println(">>>>>>> Список файлов:");
        Set<String> files = fileEditor.getFiles(directoryPath);
        files.forEach(System.out::println);

        LOGGER.debug("Запрос имени файла");
        System.out.println(">>>>>>> Введите имя файла и строку для поиска через пробел:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        LOGGER.debug("Пользователь ввел [{}]", input);
        String fileName = input.split(" ")[0];
        if (!files.contains(fileName)) {
            System.out.println(">>>>>>> Файл не найден: " + fileName);
            System.out.println(">>>>>>> Выход из приложения");
            LOGGER.warn("В директории '{}' не найден файл '{}'.", directoryPath, fileName);
            return;
        }

        if (input.split(" ").length <= 1) {
            System.out.println(">>>>>>> Пустая подстрока для поиска.");
            System.out.println(">>>>>>> Выход из приложения");
            LOGGER.warn("Пользователь не ввел подстроку для поиска." );
            return;
        }

        String substring = input.split(" ")[1];
        if (textUtils.isIncorrectSubstring(substring)) {
            System.out.println(">>>>>>> Некорректная строка для поиска: [" + substring + "]");
            System.out.println(">>>>>>> Выход из приложения");
            LOGGER.warn("Пользователь ввел некорректную строку для поиска '{}'.", substring);
            return;
        }

        int count = textUtils.countSubstringInFile(fileName, substring);
        System.out.printf(">>>>>>> В файле %s найдено [%d] строк '%s' \n", fileName, count, substring);
        LOGGER.info("В директории '{}' в файле '{}' найдено [{}] строк '{}'.", directoryPath, fileName, count, substring);
    }
}
