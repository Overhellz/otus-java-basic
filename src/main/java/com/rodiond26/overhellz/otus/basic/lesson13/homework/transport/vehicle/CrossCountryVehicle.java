package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.vehicle;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.Transport;
import lombok.Getter;

/**
 * Вездеход
 */
public class CrossCountryVehicle extends AbstractVehicle implements Transport {

    /**
     * Список типов местности, по которым может перемещаться вездеход
     */
    @Getter
    private final TerrainType[] possibleTerrainTypes = TerrainType.values();

    public CrossCountryVehicle(int fuelAmount) {
         super(fuelAmount);
    }

    @Override
    public String getType() {
        return ""; // TODO fix
    }

    @Override
    public boolean drive(int distance, TerrainType terrainType) {
        if (!isPossibleToDrive(this.possibleTerrainTypes, terrainType)) {
            return false;
        }

        return true;
    }
}
