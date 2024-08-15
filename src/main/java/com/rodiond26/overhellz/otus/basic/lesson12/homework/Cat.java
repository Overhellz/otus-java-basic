package com.rodiond26.overhellz.otus.basic.lesson12.homework;

import lombok.Getter;
import lombok.Setter;

import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

/**
 * Кот
 */
public class Cat {

    /**
     * Имя кота
     */
    @Getter
    private final String name;

    /**
     * Аппетит кота
     */
    @Getter
    @Setter
    private int appetite;

    /**
     * Кот сыт (да/нет)
     */
    @Getter
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }

    /**
     * Кот ест из тарелки plate
     *
     * @param plate тарелка
     */
    public void eatFrom(Plate plate) {
        if (plate == null) {
            log("Кот не может поесть из несуществующей тарелки");
            return;
        }

        if (this.appetite <= plate.getFoodAmount()) {
            boolean isNotEmptyPlate = plate.pickUpFood(this.appetite);
            this.isFull = true;
            log("Кот съел " + this.appetite + " ед. еды и теперь сыт");
            log("В тарелке осталась еда: " + (isNotEmptyPlate ? "да" : "нет"));
        } else {
            this.isFull = false;
            log("Коту не хватило еды в тарелке, и теперь кот голоден");
        }
    }

    public void info() {
        log("Кот " + (this.isFull ? "cыт" : "голоден"));
    }
}
