package com.rodiond26.overhellz.otus.basic.lesson17.homework;

import java.util.List;

import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

public class Homework11 {
    public static void main(String[] args) {

        PersonDataBase<Person> personDataBase = new PersonDataBaseImpl();
        Person person1 = new Person(1L, "John", Position.DIRECTOR);
        Person person2 = new Person(2L, "Eva", Position.SENIOR_MANAGER);
        Person person3 = new Person(3L, "Smith", Position.DRIVER);
        Person person4 = new Person(4L, "Mark");

        personDataBase.add(person1);
        personDataBase.add(person2);
        personDataBase.add(person3);
        personDataBase.add(person4);

        for (Long personId : List.of(1L, 2L, 3L, 4L, 5L, 6L)) {
            log(personDataBase.findById(personId));
            log(personDataBase.isManager(personDataBase.findById(personId)));
            log(personDataBase.isEmployee(personId));
            log("-------");
        }
    }
}
