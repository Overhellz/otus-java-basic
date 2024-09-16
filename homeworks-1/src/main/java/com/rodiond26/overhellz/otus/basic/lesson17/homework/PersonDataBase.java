package com.rodiond26.overhellz.otus.basic.lesson17.homework;

import java.util.Set;

public interface PersonDataBase<T extends Person> {

    /**
     * Список должностей менеджеров
     */
    Set<Position> MANAGER_POSITIONS = Set.of(
            Position.MANAGER,
            Position.DIRECTOR,
            Position.BRANCH_DIRECTOR,
            Position.SENIOR_MANAGER
    );

    /**
     * Возвращает объект Person по ID,
     * иначе возвращает null
     *
     * @param id ID
     * @return объект Person
     */
    T findById(Long id);

    /**
     * Добавление объекта Person в базу
     *
     * @param person объект Person
     */
    void add(T person);

    /**
     * Возвращает true, если Person является менеджером,
     * иначе возвращает false
     */
    boolean isManager(T person);

    /**
     * Возвращает true, если Person является сотрдуником,
     * иначе возвращает false
     */
    boolean isEmployee(Long id);
}
