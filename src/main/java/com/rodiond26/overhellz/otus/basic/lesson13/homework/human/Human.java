package com.rodiond26.overhellz.otus.basic.lesson13.homework.human;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.HumanPowerTransport;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.Transport;
import lombok.Getter;

import java.util.Arrays;

import static com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType.DENSE_FOREST;
import static com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType.PLAIN;
import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

/**
 * Человек
 */
@Getter
public class Human {

    /**
     * Имя человека
     */
    private final String name;

    /**
     * Текущее количество энергии у человека, калорий
     */
    private int caloriesAmount;

    /**
     * Список типов местности, по которым может перемещаться человек
     */
    private final TerrainType[] possibleTerrainTypes = {
            DENSE_FOREST, PLAIN
    };

    /**
     * Текущий транспорт
     */
    private Transport currentTransport;

    /**
     * Максимальное количество энергии у человека, калорий
     */
    public static final int maxCalories = 5000;

    /**
     * Расход энергии человека на 1 километр, калорий
     */
    public static final int calories1km = 60;

    public Human(String name) {
        this.name = name;
        this.caloriesAmount = maxCalories;
    }

    /**
     * Сесть в транспорт
     */
    public void getOn(Transport transport) {
        if (this.currentTransport != null) {
            log(String.format(
                    "Нельзя посадить человека в %s, потому что человек уже находится в %s",
                    transport.getType(), currentTransport.getType()));
            return;
        }
        this.currentTransport = transport;
        log("Человек сел в " + currentTransport.getType());
    }

    /**
     * Вылезти из транспорта
     */
    public void getOutOfTransport() {
        log("Человек вылез из " + this.currentTransport.getType());
        this.currentTransport = null;
    }

    /**
     * Перемещаться на расстояние distance
     *
     * @param distance    расстояние
     * @param terrainType тип местности
     */
    public void move(int distance, TerrainType terrainType) {
        if (this.currentTransport != null) {
            log("Человек использовал транспорт " + this.currentTransport.getType());
            drive(distance, terrainType);
            return;
        }
        log("Человек пошел пешком");
        walk(distance, terrainType);
    }

    /**
     * Человек едет в транспорте
     *
     * @param distance    расстояние
     * @param terrainType тип местности
     */
    private void drive(int distance, TerrainType terrainType) {
        if (currentTransport instanceof HumanPowerTransport) {


        }


        boolean isMoved = this.currentTransport.drive(distance, terrainType);
        if (isMoved) {
            log("Человек смог проехать на транспорте " + this.currentTransport.getType());
        } else {
            log("Человек не смог проехать на транспорте " + this.currentTransport.getType());
        }
    }

    /**
     * Человек идет пешком
     *
     * @param distance    расстояние
     * @param terrainType тип местности
     */
    private void walk(int distance, TerrainType terrainType) {
        if (terrainType == null || !Arrays.asList(possibleTerrainTypes).contains(terrainType)) {
            log("Человек не может пройти по этой местности");
            return;
        }

        // TODO дописать
    }
}
