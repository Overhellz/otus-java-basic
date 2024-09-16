package com.rodiond26.overhellz.otus.basic.lesson13.homework;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.human.Human;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.Bike;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.Horse;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.Transport;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.vehicle.Car;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.vehicle.CrossCountryVehicle;

import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

public class Homework07 {

    public static void main(String[] args) {

        Car car = new Car(80, 13);
        CrossCountryVehicle crossCountryVehicle = new CrossCountryVehicle(150, 30);
        Horse horse = new Horse("Лошадка");
        Bike bike = new Bike(10);
        Human human = new Human("Mark");

        Transport[] transports = {car, crossCountryVehicle, horse, bike};
        TerrainType[] terrainTypes = TerrainType.values();
        int[] distances = {1, 10, 100, 1000};

        for (Transport transport : transports) {
            for (TerrainType terrainType : terrainTypes) {
                for (int distance : distances) {
                    human.getOn(transport);
                    human.move(distance, terrainType);
                    human.getOutOfTransport();
                    human.move(distance, terrainType);
                    log("-------");
                }
            }
        }
    }
}
