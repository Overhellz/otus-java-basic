package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;
import lombok.Getter;

import static com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType.DENSE_FOREST;
import static com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType.PLAIN;
import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

/**
 * Лошадь
 */
@Getter
public class Horse implements Transport {

    /**
     * Имя лошади
     */
    private final String name;

    /**
     * Текущее количество энергии у лошади, калорий
     */
    private int caloriesAmount;

    /**
     * Максимальное количество энергии у лошади, калорий
     */
    public static final int HORSE_MAX_CALORIES = 20000;

    /**
     * Расход энергии лошади на 1 километр, калорий
     */
    public static final int HORSE_CALORIES_PER_1_KM = 50;

    /**
     * Список типов местности, по которым может перемещаться лошадь
     */
    private final TerrainType[] possibleTerrainTypes = {
            DENSE_FOREST, PLAIN
    };

    public Horse(String name) {
        this.name = name;
        this.caloriesAmount = HORSE_MAX_CALORIES;
    }

    @Override
    public String getType() {
        return "Лошадь";
    }

    @Override
    public boolean drive(int distance, TerrainType terrainType) {
        if (!isPossibleToMove(this.possibleTerrainTypes, terrainType)) {
            return false;
        }

        if ((this.maxDistance() - distance) < 0) {
            log("У лошади не хватит энергии, чтобы проехать [" + distance + " км]");
            return false;
        }
        log(String.format("Лошадь может проехать [%.1f км]", this.maxDistance()));
        caloriesAmount -= getCaloriesConsumption(distance);
        log(String.format(
                "Лошадь проехала расстояние [%d км] по местности %s, осталось [%d] калорий",
                distance, terrainType.getType(), caloriesAmount));
        return true;
    }

    @Override
    public double maxDistance() {
        return (double) caloriesAmount / HORSE_CALORIES_PER_1_KM;
    }

    /**
     * Возвращает расход калорий на расстояние distance
     * в зависимости от расхода калорий на 1 км
     *
     * @return расход калорий
     */
    private int getCaloriesConsumption(double distance) {
        if (distance < 0) {
            return 0;
        }
        return (int) (distance / DISTANCE_1_KM * HORSE_CALORIES_PER_1_KM);
    }
}
