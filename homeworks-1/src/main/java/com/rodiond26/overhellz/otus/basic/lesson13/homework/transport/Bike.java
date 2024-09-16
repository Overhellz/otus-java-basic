package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;
import lombok.Getter;

import static com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType.DENSE_FOREST;
import static com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType.PLAIN;
import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

/**
 * Велосипед
 */
@Getter
public class Bike implements Transport {

    /**
     * Список типов местности, по которым может перемещаться велосипед
     */
    private final TerrainType[] possibleTerrainTypes = {
            DENSE_FOREST, PLAIN
    };

    /**
     * Максимальное расстояние, которое может проехать человек на велосипеде, километров
     */
    private final double maxDistance;

    public Bike(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public String getType() {
        return "Велосипед";
    }

    @Override
    public boolean drive(int distance, TerrainType terrainType) {
        if (!isPossibleToMove(this.possibleTerrainTypes, terrainType)) {
            return false;
        }

        if ((this.maxDistance() - distance) < 0) {
            log("Велосипедист не может проехать рассстояние [" + distance + " км]");
            return false;
        }
        log(String.format("Велосипедист может проехать [%d км]", distance));

        return false;
    }

    @Override
    public double maxDistance() {
        return this.maxDistance;
    }
}
