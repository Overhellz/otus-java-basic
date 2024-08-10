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
    private int currentCapacity;

    public Plate(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Максимальное количество еды не может быть меньше или равно нолю");
        }
        this.maxCapacity = maxCapacity;
        this.currentCapacity = maxCapacity;
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

        this.currentCapacity += volume;
        if (this.currentCapacity > this.maxCapacity) {
            this.currentCapacity = this.maxCapacity;
        }
    }

    /**
     * Забрать еду из тарелки
     *
     * @param volume количество еды, ед.
     */
    public boolean pickUpFood(int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("Нельзя забрать еды из тарелки меньше ноля");
        }

        this.currentCapacity -= volume;
        if (this.currentCapacity < 0) {
            this.currentCapacity = 0;
            log("Из тарелки забрали всю еду. Тарелка пуста");
            return false;
        }
        log("Из тарелки забрали " + volume + " ед. еды. В тарелке осталось " + this.currentCapacity + " ед. еды");
        return true;
    }
}
