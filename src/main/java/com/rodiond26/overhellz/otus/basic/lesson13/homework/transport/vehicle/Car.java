package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.vehicle;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.Transport;
import lombok.Getter;

import static com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType.PLAIN;
import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

/**
 * Машина
 */
public class Car extends AbstractVehicle implements Transport {

    /**
     * Список типов местности, по которым может перемещаться машина
     */
    @Getter
    private final TerrainType[] possibleTerrainTypes = {
            PLAIN
    };

    public Car(int fuelAmount, double fuelPerKilometer) {
        super(fuelAmount, fuelPerKilometer);
    }

    @Override
    public String getType() {
        return "Машина";
    }

    @Override
    public boolean drive(int distance, TerrainType terrainType) {
        if (!isPossibleToDrive(this.possibleTerrainTypes, terrainType)) {
            log("Машина не может проехать по местности " + terrainType.getType());
            return false;
        }

        double maxDriveDistance = fuelAmount * fuelPerKilometer;
        if (maxDriveDistance < distance) {
            log("У машины не хватит топлива, чтобы проехать " + distance + "км");
            return false;
        }

        fuelAmount -= distance / fuelPerKilometer;
        log("Машина проехала расстояние " + distance
                + "км по местности " + terrainType.getType()
                + ", осталось топлива " + fuelAmount);
        return true;
    }
}
