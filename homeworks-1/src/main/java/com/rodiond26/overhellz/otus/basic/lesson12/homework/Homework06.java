package com.rodiond26.overhellz.otus.basic.lesson12.homework;

public class Homework06 {

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Барсик", 10),
                new Cat("Пушок", 15),
                new Cat("Рыжик", 20),
                new Cat("Пирожок", 25)
        };
        Plate plate = new Plate(50);

        for (Cat cat : cats) {
            cat.eatFrom(plate);
        }
        for (Cat cat : cats) {
            cat.info();
        }
    }
}
