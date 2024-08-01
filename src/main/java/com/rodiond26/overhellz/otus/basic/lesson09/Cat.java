package com.rodiond26.overhellz.otus.basic.lesson09;

public class Cat {
    private String name;
    private String color;
    private int age;
    private float weight;
    private float caloriesBalance;

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

    public float getWeight() {
        return weight;
    }

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.weight = 4.0f;
    }

    public void sleep() {
        System.out.println(name + " уснул");
        weight += caloriesBalance * 0.1f;
        caloriesBalance = 0;
    }

    public void jump() {
        System.out.println(name + " подпрыгнул");
        weight -= 0.001f;
        caloriesBalance -= 0.01f;
    }

    public void info() {
        System.out.println(name + " " + color + " " + age);
    }

    public void eat(float amount) {
        weight += amount / 100.0f;
        caloriesBalance += amount / 100.0f;
    }
}
