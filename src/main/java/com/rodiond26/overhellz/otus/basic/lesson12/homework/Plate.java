package com.rodiond26.overhellz.otus.basic.lesson12.homework;

/**
 * Тарелка
 */
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
        if (maxCapacity < 0) {
            throw new IllegalArgumentException("Нельзя добавить еду меньше ноля");
        }

        this.currentCapacity += volume;
        if (this.currentCapacity > this.maxCapacity) {
            this.currentCapacity = this.maxCapacity;
        }
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }
}
