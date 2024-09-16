package com.rodiond26.overhellz.otus.basic.lesson11.homework;

import com.rodiond26.overhellz.otus.basic.lesson11.homework.animal.Animal;
import com.rodiond26.overhellz.otus.basic.lesson11.homework.animal.Cat;
import com.rodiond26.overhellz.otus.basic.lesson11.homework.animal.Dog;
import com.rodiond26.overhellz.otus.basic.lesson11.homework.animal.Horse;

public class Homework05 {

    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Барсик", 5, 13),
                new Cat("Пушок", 3, 5),
                new Dog("Бобик", 10, 5, 30),
                new Dog("Рекс", 13, 7, 20),
                new Horse("Лошадка", 25, 12, 60),
                new Horse("Конек", 33, 13, 50)
        };
        for (Animal animal : animals) {
            animal.info();
            animal.run(25);
            animal.info();
            animal.swim(25);
            animal.info();
            animal.run(25);
            System.out.println("-------");
        }
    }
}
