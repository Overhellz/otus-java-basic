package com.rodiond26.overhellz.otus.basic.lesson11.lection.animals;

public class Cat extends Animal {
    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void climbOnTree() {
        System.out.println(name + " забрался на дерево");
    }

    @Override
    public void voice() {
        System.out.println(name + " мяукнул");
    }
}
