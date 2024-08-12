package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;
import lombok.Getter;

import static com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType.PLAIN;

/**
 * Машина
 */
public class Car extends AbstractCar implements Transport {

    /**
     * Список типов местности, по которым может перемещаться машина
     */
    @Getter
    private final TerrainType[] possibleTerrainTypes = {
            PLAIN
    };

    public Car(int fuelAmount) {
        super(fuelAmount);
    }

    @Override
    public boolean drive(int distance, TerrainType terrainType) {
        if (!isPossibleToDrive(this.possibleTerrainTypes, terrainType)) {
            return false;
        }

        return true;
    }
}
