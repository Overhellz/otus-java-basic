package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport;

import lombok.Getter;
import lombok.Setter;

/**
 * Абстрактная Машина
 */
@Getter
@Setter
public abstract class AbstractCar {

    /**
     * Количество топлива у машины, ед.
     */
    double fuelAmount;

    /**
     * Расход топлива на километр, ед.
     */
    double fuelPerKilometer;

    public AbstractCar(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
}
