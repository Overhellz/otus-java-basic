package com.rodiond26.overhellz.otus.basic.lesson11;

public class Horse extends Animal {

    public static final int HORSE_SWIMMING_ENDURANCE = 4;

    public Horse(String name, int runSpeed, int swimSpeed, int endurance) {
        super(
                name,
                runSpeed,
                swimSpeed,
                endurance,
                false,
                ANIMAL_RUNNING_ENDURANCE,
                HORSE_SWIMMING_ENDURANCE
        );
    }
}
