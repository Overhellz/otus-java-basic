package com.rodiond26.overhellz.otus.basic.lesson15.homework;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Сотрудник
 */
@Data
@AllArgsConstructor
public class Employee {

    /**
     * Имя
     */
    private String name;

    /**
     * Возраст
     */
    private int age;
}
