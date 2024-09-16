package com.rodiond26.overhellz.otus.basic.lesson11.lection.animals;

public class Dog extends Animal {
    int mood;

    public Dog(String name, String color, int age, int mood) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.mood = mood;
    }

    @Override
    public void run() {
        super.run();
        if (mood > 50) {
            System.out.println(name + " бегает еще от радости");
        }
    }

    @Override
    public void voice() {
        System.out.println(name + " гавкнул");
    }
}
