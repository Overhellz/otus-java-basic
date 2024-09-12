package com.rodiond26.overhellz.otus.basic.lesson21.lection;

public class AnonimousClassThread {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                }
            }
        }).start();
    }
}
