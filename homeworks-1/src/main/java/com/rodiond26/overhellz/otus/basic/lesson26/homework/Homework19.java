package com.rodiond26.overhellz.otus.basic.lesson26.homework;

public class Homework19 {

    public static void main(String[] args) {

        Fruit fruit1 = new Fruit(10);
        Fruit fruit2 = new Apple(5);
        Fruit fruit3 = new Orange(6);

        Box<Fruit> box1 = new Box<>();
        box1.put(fruit1);
        box1.put(fruit2);
        box1.put(fruit3);

        Fruit fruit4 = new Fruit(4);
        Fruit fruit5 = new Apple(6);
        Fruit fruit6 = new Orange(8);
        Box<Fruit> box2 = new Box<>();
        box2.put(fruit4);
        box2.put(fruit5);
        box2.put(fruit6);

        System.out.println(box1);
        System.out.println(box2);

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());

        box1.putAll(box2.getAll());
        System.out.println(box1);
        System.out.println(box2);
    }
}
