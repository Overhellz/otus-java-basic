package com.rodiond26.overhellz.otus.basic.lesson13.homework;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.Transport;
import lombok.Getter;

import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

/**
 * Человек
 */
public class Human {

    /**
     * Имя человека
     */
    @Getter
    private final String name;

    /**
     * Текущий транспорт
     */
    @Getter
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }

    /**
     * Сесть в транспорт
     */
    public void getOn(Transport transport) {
        if (this.currentTransport != null) {
            log("Нельзя посадить человека в транспорт, потому что человек уже находится в транспорте");
            return;
        }
        this.currentTransport = transport;
        log("Человек сел в транпорт");
    }

    /**
     * Вылезти из транспорта
     */
    public void getOutOfTransport() {
        log("Человек вылез из " + this.currentTransport.getType());
        this.currentTransport = null;
    }

    /**
     * Ехать в транспорте
     *
     * @param distance    расстояние
     * @param terrainType тип местности
     */
    public void drive(int distance, TerrainType terrainType) {
        boolean isMoved = this.currentTransport.drive(distance, terrainType);
        if (isMoved) {
            log("Человек смог проехать на транспорте " + this.currentTransport.getType());
        } else {
            log("Человек не смог проехать на транспорте " + this.currentTransport.getType());
        }
    }
}
