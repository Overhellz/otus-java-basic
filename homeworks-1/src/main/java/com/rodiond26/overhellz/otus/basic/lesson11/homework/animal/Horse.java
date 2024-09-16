package com.rodiond26.overhellz.otus.basic.lesson11.homework.animal;

public class Horse extends Animal {

    public static final int HORSE_SWIMMING_ENDURANCE = 4;

    public Horse(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        super(
                name,
                runningSpeed,
                swimmingSpeed,
                endurance,
                false,
                ANIMAL_RUNNING_ENDURANCE,
                HORSE_SWIMMING_ENDURANCE
        );
    }

    @Override
    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format(
                "Лошадь: кличка - %s, скорость бега - %d, скорость плавания - %d, выносливость - %d, устал - %s",
                this.name,
                this.runningSpeed,
                this.swimmingSpeed,
                this.endurance,
                this.isTired ? "да" : "нет"
        );
    }
}
