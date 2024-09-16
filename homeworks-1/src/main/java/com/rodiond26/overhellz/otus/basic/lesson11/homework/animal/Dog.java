package com.rodiond26.overhellz.otus.basic.lesson11.homework.animal;

public class Dog extends Animal {

    public static final int DOG_SWIMMING_ENDURANCE = 2;

    public Dog(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        super(
                name,
                runningSpeed,
                swimmingSpeed,
                endurance,
                false,
                ANIMAL_RUNNING_ENDURANCE,
                DOG_SWIMMING_ENDURANCE
        );
    }

    @Override
    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format(
                "Собака: кличка - %s, скорость бега - %d, скорость плавания - %d, выносливость - %d, устал - %s",
                this.name,
                this.runningSpeed,
                this.swimmingSpeed,
                this.endurance,
                this.isTired ? "да" : "нет"
        );
    }
}
