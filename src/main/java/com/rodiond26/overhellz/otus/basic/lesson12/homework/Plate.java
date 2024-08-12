package com.rodiond26.overhellz.otus.basic.lesson12.homework;

import lombok.Getter;

import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

/**
 * Тарелка
 */
@Getter
public class Plate {

    /**
     * Максимальное количество еды, ед.
     */
    private final int maxCapacity;

    /**
     * Текущее количество еды, ед.
     */
    private int foodAmount;

    public Plate(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Максимальное количество еды не может быть меньше или равно нолю");
        }
        this.maxCapacity = maxCapacity;
        this.foodAmount = maxCapacity;
    }

    /**
     * Добавить еду в тарелку
     *
     * @param volume количество еды, ед.
     */
    public void addFood(int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("Нельзя добавить еду меньше ноля");
        }

        this.foodAmount += volume;
        if (this.foodAmount > this.maxCapacity) {
            this.foodAmount = this.maxCapacity;
        }
    }

    /**
     * Возвращает наличие еды в тарелке после того, как из тарелки взяли еду
     *
     * @param volume количество еды, ед.
     * @return В тарелке осталась еда (да/нет)
     */
    public boolean pickUpFood(int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("Нельзя забрать еды из тарелки меньше ноля");
        }

        this.foodAmount -= volume;
        if (this.foodAmount < 0) {
            this.foodAmount = 0;
            log("Из тарелки забрали всю еду. Тарелка пуста");
            return false;
        }
        log("Из тарелки забрали " + volume + " ед. еды. В тарелке осталось " + this.foodAmount + " ед. еды");
        return true;
    }
}
