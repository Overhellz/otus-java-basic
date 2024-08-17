package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;
import lombok.Getter;
import lombok.Setter;

import static com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType.DENSE_FOREST;
import static com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType.PLAIN;
import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

/**
 * Велосипед
 */
@Getter
public class Bike implements HumanPowerTransport {

    /**
     * Список типов местности, по которым может перемещаться велосипед
     */
    private final TerrainType[] possibleTerrainTypes = {
            DENSE_FOREST, PLAIN
    };

    /**
     * Количество энергии у велосипедиста, калорий
     */
    @Setter
    private int driverEnergy;

    /**
     * Затраты калорий велосипедиста на 1 км, калорий
     */
    @Setter
    private int driverEnergyPer1km;

    public Bike() {
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
        if (driverEnergy <= 0) {
            log("У велосипедиста нет энергии, чтобы ехать");
            return false;
        }
        if ((this.maxDistance() - distance) < 0) {
            log("У велосипедиста не хватит энергии, чтобы проехать [" + distance + " км]");
            return false;
        }
        log(String.format("Велосипедист может проехать [%.1f км]", this.maxDistance()));


        return false;
    }

    @Override
    public double maxDistance() {
        if (getDriverEnergy() <= 0 || getDriverEnergyPer1km() <= 0) {
            return 0;
        }
        return (double) getDriverEnergy() / getDriverEnergyPer1km();
    }
}
