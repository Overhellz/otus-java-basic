package com.rodiond26.overhellz.otus.basic.lesson26.homework;

public class Orange extends Fruit {

    public Orange(int weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "Orange{weight=" + super.getWeight() + '}';
    }
}
