package com.rodiond26.overhellz.otus.basic.lesson09;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Unknown", "Black", 4);
        cat1.info();

        Cat cat2 = new Cat("Murzik", "White", 2);
        cat2.info();

        cat1.setName(cat2.getName());
        System.out.println(cat1.getName());

        cat1.info();
        String s = "Java";

        Scanner scanner = new Scanner(System.in);
    }
}
