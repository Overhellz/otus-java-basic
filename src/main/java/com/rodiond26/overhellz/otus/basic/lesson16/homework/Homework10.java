package com.rodiond26.overhellz.otus.basic.lesson16.homework;

import com.rodiond26.overhellz.otus.basic.lesson16.homework.exception.IncorrectNameException;
import com.rodiond26.overhellz.otus.basic.lesson16.homework.exception.IncorrectPhoneNumberException;

import java.util.Set;

import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

public class Homework10 {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Mark", "123");
        phoneBook.add("Mark", "4567890");
        phoneBook.add("John", "333333333");
        phoneBook.add("Lisa", "123");
        phoneBook.add("Lisa", "3444");
        log(phoneBook.toString());

        Set<String> lisaPhoneNumbers = phoneBook.find("Lisa");
        log(lisaPhoneNumbers.toString());

        Set<String> maximPhoneNumbers = phoneBook.find("Maxim");
        log(maximPhoneNumbers.toString());

        boolean containsNumber123 = phoneBook.containsPhoneNumber("123");
        log(String.valueOf(containsNumber123));

        try {
            phoneBook.add(null, "3444");
        } catch (IncorrectNameException e) {
            log("Обработали ошибку " + e.getClass().getSimpleName());
        }

        try {
            phoneBook.add("Lisa", "111111111111111111111111111");
        } catch (IncorrectPhoneNumberException e) {
            log("Обработали ошибку " + e.getClass().getSimpleName());
        }
    }
}
