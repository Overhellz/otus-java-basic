package com.rodiond26.overhellz.otus.basic.lesson16.homework.exception;

public class IncorrectNameException extends RuntimeException {

    public IncorrectNameException() {
        super();
    }

    public IncorrectNameException(String message) {
        super(message);
    }
}
