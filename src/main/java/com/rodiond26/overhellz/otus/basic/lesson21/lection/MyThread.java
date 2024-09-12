package com.rodiond26.overhellz.otus.basic.lesson21.lection;

// 1. Создание потока - через наследование от класса Thread
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
