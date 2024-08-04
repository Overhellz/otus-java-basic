package com.rodiond26.overhellz.otus.basic.lesson11.lection.animals;

public class Horse extends Animal {
    public Horse(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public void voice() {
        System.out.println(name + " заржала");
    }
}
