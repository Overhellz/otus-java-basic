package com.rodiond26.overhellz.otus.basic.lesson26.homework;

public class Apple extends Fruit {

    public Apple(int weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "Apple{weight=" + super.getWeight() + '}';
    }
}
