package com.rodiond26.overhellz.otus.basic.lesson15.homework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Сотрудник
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
