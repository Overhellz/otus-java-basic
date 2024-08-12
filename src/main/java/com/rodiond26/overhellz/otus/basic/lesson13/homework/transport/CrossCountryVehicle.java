package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;
import lombok.Getter;
import lombok.Setter;

/**
 * Вездеход
 */
public class CrossCountryVehicle extends AbstractCar implements Transport {

    /**
     * Список типов местности, по которым может перемещаться вездеход
     */
    @Getter
    private final TerrainType[] possibleTerrainTypes = TerrainType.values();

    public CrossCountryVehicle(int fuelAmount) {
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
