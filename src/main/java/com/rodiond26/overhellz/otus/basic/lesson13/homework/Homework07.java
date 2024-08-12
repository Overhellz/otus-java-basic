package com.rodiond26.overhellz.otus.basic.lesson13.homework;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.AbstractCar;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.Car;
import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.CrossCountryVehicle;

import java.util.Arrays;

public class Homework07 {
    /*
      Реализуйте в вашем приложении классы Машина, Лошадь, Велосипед, Вездеход

     Человек должен иметь возможность сесть на любой из этих видов транспорта,
      встать с него, или переместиться на некоторое расстояние
       (при условии что он находится на каком-либо транспорте)

     При попытке выполнить перемещение у человека, не использующего транспорт,
      считаем что он просто идет указанное расстояние пешком

     При перемещении Машина и Вездеход тратят бензин, который у них ограничен.
     Лошадь тратит силы.
     Велосипед может использоваться без ограничений (можете для усложнения
     велосипедом тратить силы “водителя”).
     При выполнении действия результат должен быть отпечатан в консоль

     У каждого вида транспорта есть местности по которым он не может перемещаться:

      лошадь и велосипед - болото,

      */

    public static void main(String[] args) {
        AbstractCar car1 = new Car(123);
        AbstractCar car2 = new CrossCountryVehicle(4444);


        System.out.println(car1.drive(10, TerrainType.SWAMP));
        System.out.println(car2.drive(10, TerrainType.SWAMP));
    }
}
