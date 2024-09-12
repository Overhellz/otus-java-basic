package com.rodiond26.overhellz.otus.basic.lesson21.lection;

// 1. Создание потока - через реализацию интерфейса Runnable
public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
