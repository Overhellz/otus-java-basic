package com.rodiond26.overhellz.otus.basic.lesson21.lection;

public class CounterApplication {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            }
        }) ;
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.decrement();
                }
            }
        }) ;

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getValue());
    }
}
