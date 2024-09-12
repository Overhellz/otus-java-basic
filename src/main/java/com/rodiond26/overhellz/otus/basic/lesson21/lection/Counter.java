package com.rodiond26.overhellz.otus.basic.lesson21.lection;

public class Counter {

    private int value;

    public int getValue() {
        return value;
    }

    public synchronized void increment() {
        value++;
    }

    public synchronized void decrement() {
        value--;
    }
}
