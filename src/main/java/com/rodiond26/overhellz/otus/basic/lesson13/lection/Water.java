package com.rodiond26.overhellz.otus.basic.lesson13.lection;

public class Water implements Obstacle {
    private int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public boolean doIt(Participant participant) {
        return participant.swim(length);
    }
}
