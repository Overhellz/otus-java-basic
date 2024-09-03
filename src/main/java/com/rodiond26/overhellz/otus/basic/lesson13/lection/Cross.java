package com.rodiond26.overhellz.otus.basic.lesson13.lection;

public class Cross implements Obstacle {
    private int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public boolean doIt(Participant participant) {
        return participant.run(length);
    }
}
