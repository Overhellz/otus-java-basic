package com.rodiond26.overhellz.otus.basic.lesson13.homework;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.human.Human;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.vehicle.Car;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.vehicle.CrossCountryVehicle;

import static com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType.PLAIN;
import static com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType.SWAMP;

public class Homework07 {

    public static void main(String[] args) {
        Car car = new Car(80, 13);
        CrossCountryVehicle crossCountryVehicle = new CrossCountryVehicle(150, 30);
        Human human = new Human("Mark");
        human.getOn(car);
        human.move(10000, PLAIN);
        human.getOutOfTransport();

        human.getOn(car);
        human.move(100, SWAMP);
        human.getOutOfTransport();

        human.getOn(crossCountryVehicle);
        human.move(500, PLAIN);
        human.getOutOfTransport();

        human.getOn(crossCountryVehicle);
        human.move(300, SWAMP);
        human.getOutOfTransport();
    }
}
