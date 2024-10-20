package com.rodiond26.overhellz.otus.basic.lesson28.homework;

import java.util.function.Predicate;

public class Homework21 {

    private final Object monitor = new Object();
    private String str = "";

    public static void main(String[] args) {
        Homework21 app = new Homework21();
        int count = 5;

        new Thread(() -> app.printC(count)).start();
        new Thread(() -> app.printB(count)).start();
        new Thread(() -> app.printA(count)).start();
    }

    public void printA(int count) {
        print("A", count, conditionToPrintA());
    }

    public void printB(int count) {
        print("B", count, conditionToPrintB());
    }

    public void printC(int count) {
        print("C", count, conditionToPrintC());
    }

    public void print(String val, int count, Predicate<String> predicate) {
        synchronized (monitor) {
            try {
                for (int i = 0; i < count; i++) {
                    while (predicate.test(str)) {
                        monitor.wait();
                    }
                    str = val;
                    System.out.print(str);
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Predicate<String> conditionToPrintA() {
        return str -> str != null && !str.isEmpty() && !str.equals("C");
    }

    Predicate<String> conditionToPrintB() {
        return str -> !str.equals("A");
    }

    Predicate<String> conditionToPrintC() {
        return str -> !str.equals("B");
    }
}
