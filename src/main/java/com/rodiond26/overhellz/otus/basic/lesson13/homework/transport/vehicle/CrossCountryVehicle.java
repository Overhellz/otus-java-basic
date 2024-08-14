package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.vehicle;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.Transport;
import lombok.Getter;

import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

/**
 * Вездеход
 */
@Getter
public class CrossCountryVehicle extends AbstractVehicle implements Transport {

    /**
     * Список типов местности, по которым может перемещаться вездеход
     */
    private final TerrainType[] possibleTerrainTypes = TerrainType.values();

    public CrossCountryVehicle(int fuelAmount, double fuelPerKilometer) {
        super(fuelAmount, fuelPerKilometer);
    }

    @Override
    public String getType() {
        return "Вездеход";
    }

    @Override
    public boolean drive(int distance, TerrainType terrainType) {
        if (!isPossibleToMove(this.possibleTerrainTypes, terrainType)) {
            log("Вездеход не может проехать по местности " + terrainType.getType());
            return false;
        }

        if ((this.maxDistance() - distance) < 0) {
            log("У вездеход не хватит топлива, чтобы проехать [" + distance + " км]");
            return false;
        }
        log(String.format("Вездеход может проехать [%.1f км]", this.maxDistance()));
        fuelAmount -= this.getFuelConsumption(distance);
        log(String.format(
                "Вездеход проехал расстояние [%d км] по местности %s, осталось топлива [%.1f л]",
                distance, terrainType.getType(), fuelAmount));
        return true;
    }
}
