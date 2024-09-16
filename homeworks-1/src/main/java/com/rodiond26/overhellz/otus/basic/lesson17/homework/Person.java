package com.rodiond26.overhellz.otus.basic.lesson17.homework;

import lombok.Data;

@Data
public class Person {

    /**
     * Идентификатор
     */
    private final Long id;

    /**
     * Имя
     */
    private final String name;

    /**
     * Должность
     */
    private Position position;

    public Person(Long id, String name) {
        this(id, name, null);
    }

    public Person(Long id, String name, Position position) {
        if (id < 0) {
            throw new IllegalArgumentException("Идентификатор не может быть меньше нуля: " + id);
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя имеет некорректное значение: " + name);
        }
        this.id = id;
        this.name = name;
        this.position = position;
    }
}
