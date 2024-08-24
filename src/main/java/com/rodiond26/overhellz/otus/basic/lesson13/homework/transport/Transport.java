package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;

/**
 * Интерфейс траспорта общего вида
 */
public interface Transport {

    /**
     * Расстояние = 1 километр
     */
    double DISTANCE_1_KM = 1;

    /**
     * Возвращает наименование транспорта
     */
    String getType();

    /**
     * Возвращает результат перемещения на транспорте
     * на расстояние distance по местности типа terrainType
     *
     * @param distance    расстояние для перемещения, ед.
     * @param terrainType тип местности
     * @return действие выполнено/не выполнено
     */
    boolean drive(int distance, TerrainType terrainType);

    /**
     * Проверяет возможность перемещения по типу местности terrainType
     *
     * @param possibleTerrainTypes типы местности, по которым может проехать транспорт
     * @param terrainType          тип местности, который проверяется
     * @return есть/нет возможности проехать
     */
    default boolean isPossibleToMove(TerrainType[] possibleTerrainTypes,
                                     TerrainType terrainType) {
        if (possibleTerrainTypes == null
                || possibleTerrainTypes.length == 0
                || terrainType == null) {
            return false;
        }

        for (TerrainType type : possibleTerrainTypes) {
            if (type == terrainType) {
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает максимальное расстояние, которое может преодолеть транспорт
     *
     * @return максимальное расстояние, км
     */
    double maxDistance();
}
