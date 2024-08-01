package com.rodiond26.overhellz.otus.basic.lesson11;

public class Dog extends Animal {

    public static final int DOG_SWIMMING_ENDURANCE = 2;

    public Dog(String name, int runSpeed, int swimSpeed, int endurance) {
        super(
                name,
                runSpeed,
                swimSpeed,
                endurance,
                false,
                ANIMAL_RUNNING_ENDURANCE,
                DOG_SWIMMING_ENDURANCE
        );
    }
}
