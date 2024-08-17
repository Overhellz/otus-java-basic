package com.rodiond26.overhellz.otus.basic.lesson16.homework;

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
    }
}
