package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.vehicle;

import lombok.Getter;
import lombok.Setter;

/**
 * Абстрактное транспортное средство
 */
public abstract class AbstractVehicle {

    /**
     * Расстояние = 100 километров
     */
    public static final double DISTANCE_100_KM = 100;

    /**
     * Расход топлива на 100 километров, ед.
     */
    @Getter
    final double fuel100km;

    /**
     * Количество топлива у транспортного средства, ед.
     */
    @Getter
    @Setter
    double fuelAmount;

    public AbstractVehicle(double fuelAmount, double fuel100km) {
        if (fuelAmount < 0) {
            throw new IllegalArgumentException("Количество топлива не может быть меньше нуля");
        }
        if (fuel100km <= 0) {
            throw new IllegalArgumentException("Расход топлива должен быть больше нуля");
        }
        this.fuelAmount = fuelAmount;
        this.fuel100km = fuel100km;
    }

    /**
     * Возвращает максимальное расстояние,
     * которое может преодолеть транспорт в зависимости от расхода топлива на 100 км
     *
     * @return максимальное расстояние, ед
     */
    double maxDistance() {
        return fuelAmount / fuel100km * DISTANCE_100_KM;
    }

    /**
     * Возвращает расход топлива на расстояние distance
     * в зависимости от расхода топлива на 100 км
     *
     * @return расход топлива, ед
     */
    double getFuelConsumption(int distance) {
        if (distance < 0) {
            return 0;
        }
        return distance / DISTANCE_100_KM * fuel100km;
    }
}
