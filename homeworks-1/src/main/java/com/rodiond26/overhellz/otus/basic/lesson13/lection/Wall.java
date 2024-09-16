package com.rodiond26.overhellz.otus.basic.lesson13.lection;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean doIt(Participant participant) {
        return participant.jump(height);
    }
}
