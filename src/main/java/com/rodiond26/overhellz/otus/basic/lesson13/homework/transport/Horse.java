package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;
import lombok.Getter;

import static com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType.PLAIN;

/**
 * Лошадь
 */
public class Horse implements Transport {

    /**
     * Список типов местности, по которым может перемещаться лошадь
     */
    @Getter
    private final TerrainType[] possibleTerrainTypes = {
            PLAIN
    };

    public Horse(int fuelAmount) {
        super(fuelAmount);
    }

    @Override
    public String getType() {
        return ""; // TODO fix
    }

    @Override
    public boolean drive(int distance, TerrainType terrainType) {
        if (!isPossibleToMove(this.possibleTerrainTypes, terrainType)) {
            return false;
        }

        return false;
    }
}
