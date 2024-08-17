package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport;

/**
 * Интерфейс траспорта, который расходует энергию человека
 */
public interface HumanPowerTransport extends Transport {

    /**
     * Количество энергии у человека
     */
    int getDriverEnergy();

    /**
     * Затраты энергии человека на 1 км, калорий
     */
    int getDriverEnergyPer1km();

    /**
     * Возвращает расход калорий на расстояние distance
     * в зависимости от расхода калорий на 1 км
     *
     * @return расход калорий
     */
    default int getCaloriesConsumption(double distance) {
        if (distance < 0) {
            return 0;
        }
        return (int) (distance / DISTANCE_1_KM * getDriverEnergyPer1km());
    }
}
