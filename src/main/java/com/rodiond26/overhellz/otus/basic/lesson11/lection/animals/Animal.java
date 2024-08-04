package com.rodiond26.overhellz.otus.basic.lesson11.lection.animals;

public abstract class Animal {
    String name;
    String color;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void run() {
        System.out.println(name + " побежал");
    }

    public void info() {
        System.out.println(name + " - " + color + " - " + age);
    }

    public abstract void voice();
}
