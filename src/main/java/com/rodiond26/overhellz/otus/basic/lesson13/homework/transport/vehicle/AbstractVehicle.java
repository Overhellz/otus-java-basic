package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.vehicle;

import lombok.Getter;
import lombok.Setter;

/**
 * Абстрактное транспортное средство
 */
public abstract class AbstractVehicle {

    /**
     * Количество топлива у транспортного средства, ед.
     */
    @Getter
    @Setter
    double fuelAmount;

    /**
     * Расход топлива на километр, ед.
     */
    @Getter
    final double fuelPerKilometer;

    public AbstractVehicle(double fuelAmount, double fuelPerKilometer) {
        if (fuelAmount < 0) {
            throw new IllegalArgumentException("Количество топлива не может быть меньше нуля");
        }
        if (fuelPerKilometer <= 0) {
            throw new IllegalArgumentException("Расход топлива должен быть больше нуля");
        }
        this.fuelAmount = fuelAmount;
        this.fuelPerKilometer = fuelPerKilometer;
    }

    /**
     * Расход топлива на расстояние distance
     */
    public double consumedFuel(int distance) {
        return distance / fuelPerKilometer;
    }
}
