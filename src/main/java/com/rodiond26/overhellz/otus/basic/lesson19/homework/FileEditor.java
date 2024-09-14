package com.rodiond26.overhellz.otus.basic.lesson19.homework;

import com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static com.rodiond26.overhellz.otus.basic.utils.CollectionUtil.isEmpty;

public class FileEditor {

    private File currentFile;
    private String currentDirectoryPath;

    public static final String PROJECT_ROOT_PATH = ".";

    // Вывести список файлов из корневого каталоге проекта
    public void printFileList(String directoryPath) {
        currentDirectoryPath = isEmpty(directoryPath) ? PROJECT_ROOT_PATH : directoryPath;
        this.getFiles(directoryPath).forEach(ConsolePrinter::log);
    }

    public Set<String> getFiles(String directoryPath) {
        return Arrays.stream(Objects.requireNonNull(new File(directoryPath).listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    // Запросить имя файла, с которым хочет работать пользователь
    public String getUserFile() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine().trim();
        return null; // TOD fix
    }

    public void readAndPrint(String fileName) {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(fileName))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            System.out.println(">>>>>>> Введите строку:");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            writer.write(str);
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
