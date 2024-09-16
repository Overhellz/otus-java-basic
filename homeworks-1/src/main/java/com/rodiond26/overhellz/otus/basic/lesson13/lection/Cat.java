package com.rodiond26.overhellz.otus.basic.lesson13.lection;

public class Cat implements Participant {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;

    @Override
    public String getName() {
        return name;
    }

    public Cat(String name) {
        this.name = name;
        this.maxRunDistance = 10000;
        this.maxJumpHeight = 100;
    }

    @Override
    public boolean run(int distance) {
        if (distance > maxRunDistance) {
            System.out.println("Кот устал");
            return false;
        }
        System.out.println("Кот прошел успешно");
        return true;
    }

    @Override
    public boolean jump(int height) {
        if (height > maxJumpHeight) {
            System.out.println("Кот не смог перепрыгнуть стену");
            return false;
        }
        System.out.println("Кот смог перепрыгнуть стену");
        return true;
    }

    @Override
    public boolean swim(int distance) {
        if (distance < 10) {
            System.out.println("Кот просто перепрыгнул воду");
            return true;
        }
        System.out.println("Кот не захотел плыть");
        return false;
    }
}
