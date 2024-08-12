package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;
import lombok.Getter;

import static com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType.PLAIN;

/**
 * Велосипед
 */
public class Bike implements Transport {

    /**
     * Список типов местности, по которым может перемещаться машина
     */
    @Getter
    private final TerrainType[] possibleTerrainTypes = {
            PLAIN
    };

    public Bike(int fuelAmount) {
        super(fuelAmount);
    }

    @Override
    public String getType() {
        return "";
    }

    @Override
    public boolean drive(int distance, TerrainType terrainType) {
        return false;
    }
}
