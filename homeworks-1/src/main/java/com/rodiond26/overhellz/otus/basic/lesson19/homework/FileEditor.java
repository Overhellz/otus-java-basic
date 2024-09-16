package com.rodiond26.overhellz.otus.basic.lesson19.homework;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileEditor {

    private final Scanner scanner = new Scanner(System.in);
    public static final String INPUT_END = "<END>";

    /**
     * Выводит список файлов в каталоге directoryPath
     */
    public void printFileList(String directoryPath) {
        this.getFiles(directoryPath).forEach(System.out::println);
    }

    /**
     * Возвращает список файлов из каталога directoryPath
     */
    public Set<String> getFiles(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Указанный путь не является директорией");
        }

        File[] files = directory.listFiles();
        if (files == null) {
            return Collections.emptySet();
        }

        return Arrays.stream(files)
                .filter(File::isFile)
                .map(File::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    /**
     * Возврашает имя файла, которое ввел пользователь
     */
    public String getUserFile() {
        return scanner.nextLine().trim();
    }

    /**
     * Выводит в консоль содержимое файла fileName
     */
    public boolean readAndPrint(String fileName) {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(fileName))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не существует: " + fileName);
            return false;
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
            return false;
        }
    }

    /**
     * Записывает в файл fileName ввод пользователя
     */
    public void write(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            System.out.println(">>>>>>> Введите строку или для окончания ввода напечатайте <END>:");
            while (true) {
                String str = scanner.nextLine();
                if (str.trim().equalsIgnoreCase(INPUT_END)) {
                    break;
                }
                writer.write(str + System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}
