package com.rodiond26.overhellz.otus.basic.lesson13.lection;

public class Application {
    public static void main(String[] args) {
        Participant[] participants = {
                new Cat("Barsik"),
                new Human("Jack"),
                new Robot("TX-1000")
        };
        Obstacle[] obstacles = {
                new Cross(1000),
                new Wall(5000),
                new Cross(1000)
        };

        for (Participant p : participants) {
            for (Obstacle o : obstacles) {
                if (!o.doIt(p)) {
                    System.out.println(p.getName() + " не справился с этапом и выходит из гонки");
                    break;
                }
            }
        }
        System.out.println("Все кто не не справился - молодцы!!!");
    }
}
