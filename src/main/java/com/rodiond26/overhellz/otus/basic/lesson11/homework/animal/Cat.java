package com.rodiond26.overhellz.otus.basic.lesson11.homework.animal;

public class Cat extends Animal {

    public static final int CAT_SWIMMING_ENDURANCE = 0;
    public static final int CAT_SWIMMING_SPEED = 0;

    public Cat(String name, int runningSpeed, int endurance) {
        super(
                name,
                runningSpeed,
                CAT_SWIMMING_SPEED,
                endurance,
                false,
                ANIMAL_RUNNING_ENDURANCE,
                CAT_SWIMMING_ENDURANCE
        );
    }

    @Override
    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format(
                "Кот: имя - %s, скорость бега - %d, не умеет плавать, выносливость - %d, устал - %s",
                this.name,
                this.runningSpeed,
                this.endurance,
                this.isTired ? "да" : "нет"
        );
    }
}
