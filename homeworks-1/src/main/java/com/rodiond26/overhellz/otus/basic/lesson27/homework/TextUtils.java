package com.rodiond26.overhellz.otus.basic.lesson27.homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextUtils {

    private static final Logger LOGGER = LogManager.getLogger(TextUtils.class.getName());

    public TextUtils() {
    }

    /**
     * Возвращает количество подстрок substring в файле fileName
     */
    public int countSubstringInFile(String fileName, String substring) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Pattern pattern = Pattern.compile(Pattern.quote(substring));

            while ((line = reader.readLine()) != null) {
                count += findOccurrencesOfSubstring(line, substring, pattern);
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Не удалось найти файл {}", fileName);
        } catch (IOException e) {
            LOGGER.error("Ошибка ввода-вывода: {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Произошла ошибка во время работы: {}", e.getMessage());
        }

        return count;
    }

    /**
     * Возвращает количество подстрок substring в строке input
     */
    public int findOccurrencesOfSubstring(String input, String substring, Pattern pattern) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        if (isIncorrectSubstring(substring)) {
            return 0;
        }
        if (input.length() < substring.length()) {
            return 0;
        }

        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
     * Возвращает строку substring на некорректность
     */
    public boolean isIncorrectSubstring(String substring) {
        return substring == null || substring.isEmpty();
    }
}
