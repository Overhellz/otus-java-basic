package com.rodiond26.overhellz.otus.basic.lesson21.lection;

public class Lection21 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        // 1 пример
//        MyThread myThread = new MyThread();
//        myThread.run(); // запуск в текущем потоке
//        myThread.start(); // запуск в параллельном потоке
//
//        Thread myTask = new Thread(new MyTask());
//        myTask.start();


        // 2 пример
        //        Thread t1 = new Thread(() -> {
//            System.out.println(Thread.currentThread().getName());
//            System.out.println("Start 1");
//        });
//        Thread t2 = new Thread(() -> {
//            System.out.println(Thread.currentThread().getName());
//            System.out.println("Start 2");
//        });
//        Thread t3 = new Thread(() -> {
//            System.out.println(Thread.currentThread().getName());
//            System.out.println("Start 3");
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();

        // 3 пример

//        System.out.println("main start");
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                while (true) {
//                    try {
//                        Thread.sleep(1000);
//                        System.out.println("tick");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        t.setDaemon(true);
//        t.start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    System.out.println(1);
//                    Thread.sleep(6400);
//                    System.out.println("tick");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(2);
//            }
//        }).start();
//
//        try {
//            Thread.sleep(4500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("main end");

        // 4 пример join

        System.out.println("main start");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < 10; i++) {
                    System.out.println("t1 > " + i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < 10; i++) {
                    System.out.println("t2 > " + i);
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join(); // поток main ждет, пока завершится поток t1
            t2.join(); // поток main ждет, пока завершится поток t2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}
