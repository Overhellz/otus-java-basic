package com.rodiond26.overhellz.otus.basic.lesson13.lection;

public class Robot implements Participant {
    private String name;
    private int maxEnergy;
    private int energy;

    @Override
    public String getName() {
        return name;
    }

    public Robot(String name) {
        this.name = name;
        this.maxEnergy = 100000;
        this.energy = maxEnergy;
    }

    @Override
    public boolean run(int distance) {
        if (distance > energy) {
            System.out.println("Робот устал");
            return false;
        }
        energy -= distance;
        System.out.println("Робот пробежал успешно");
        return true;
    }

    @Override
    public boolean jump(int height) {
        if (height * 10 > energy) {
            System.out.println("Робот не смог перепрыгнуть стену");
            return false;
        }
        System.out.println("Робот смог перепрыгнуть стену");
        energy -= height * 10;
        return true;
    }

    @Override
    public boolean swim(int distance) {
        if (distance > energy) {
            System.out.println("Робот не смог проплыть дистанцию");
            return false;
        }
        System.out.println("Робот смог проплыть дистанцию");
        energy -= distance;
        return true;
    }
}
