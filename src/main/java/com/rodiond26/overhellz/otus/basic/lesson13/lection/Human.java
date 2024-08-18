package com.rodiond26.overhellz.otus.basic.lesson13.lection;

public class Human implements Participant {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;
    private int maxSwimDistance;

    @Override
    public String getName() {
        return name;
    }

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 10000;
        this.maxSwimDistance = 500;
        this.maxJumpHeight = 100;
    }

    @Override
    public boolean run(int distance) {
        if (distance > maxRunDistance) {
            System.out.println("Человек устал");
            return false;
        }
        System.out.println("Человек пробежал успешно");
        return true;
    }

    @Override
    public boolean jump(int height) {
        if (height > maxJumpHeight) {
            System.out.println("Человек не смог перепрыгнуть стену");
            return false;
        }
        System.out.println("Человек смог перепрыгнуть стену");
        return true;
    }

    @Override
    public boolean swim(int distance) {
        if (distance > maxSwimDistance) {
            System.out.println("Человек не смог проплыть дистанцию");
            return false;
        }
        System.out.println("Человек смог проплыть дистанцию");
        return true;
    }
}
