package com.rodiond26.overhellz.otus.basic.lesson16.homework.exception;

public class IncorrectPhoneNumberException extends RuntimeException {

    public IncorrectPhoneNumberException() {
        super();
    }

    public IncorrectPhoneNumberException(String message) {
        super(message);
    }
}
