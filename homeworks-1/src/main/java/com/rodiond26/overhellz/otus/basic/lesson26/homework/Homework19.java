package com.rodiond26.overhellz.otus.basic.lesson26.homework;

import static com.rodiond26.overhellz.otus.basic.lesson26.homework.Box.move;

public class Homework19 {

    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < 5; i++) {
            appleBox.put(new Apple(i));
        }
        System.out.println(appleBox);

        Box<Orange> orangeBox = new Box<>();
        for (int i = 5; i < 10; i++) {
            orangeBox.put(new Orange(i));
        }
        System.out.println(orangeBox);

        Box<Fruit> fruitBox = new Box<>();
        System.out.println(fruitBox); // list=[]

        move(fruitBox, appleBox);
        System.out.println(fruitBox);
        // Box(list=[Apple{weight=0}, Apple{weight=1}, Apple{weight=2}, Apple{weight=3}, Apple{weight=4}])

        move(fruitBox, orangeBox);
        System.out.println(fruitBox);
        // Box(list=[Apple{weight=0}, Apple{weight=1}, Apple{weight=2}, Apple{weight=3}, Apple{weight=4},
        // Orange{weight=5}, Orange{weight=6}, Orange{weight=7}, Orange{weight=8}, Orange{weight=9}])

        System.out.println(fruitBox.getWeight()); // 45

        System.out.println(appleBox); // list=[]
        System.out.println(orangeBox); // list=[]
    }
}
