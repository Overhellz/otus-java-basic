package com.rodiond26.overhellz.otus.basic.lesson11;

public class Cat extends Animal {

    public static final int CAT_SWIMMING_ENDURANCE = 0;

    public Cat(String name, int runSpeed, int endurance) {
        super(
                name,
                runSpeed,
                0,
                endurance,
                false,
                ANIMAL_RUNNING_ENDURANCE,
                CAT_SWIMMING_ENDURANCE
        );
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", runSpeed=" + runSpeed +
                ", swimSpeed=" + swimSpeed +
                ", endurance=" + endurance +
                ", isTired=" + isTired +
                ", runningEndurance=" + runningEndurance +
                ", swimmingEndurance=" + swimmingEndurance +
                '}';
    }

//    @Override
//    public String toString() {
//        return String.format(
//                "Коробка: длина = %d, ширина = %d, высота = %d, цвет = %s, открыта = %s\nПредмет в коробке: %s",
//                this.length,
//                this.width,
//                this.height,
//                this.color,
//                this.isOpen ? "да" : "нет",
//                this.nestedObject == null ? "отсутствует" : this.nestedObject
//        );
//    }
}
