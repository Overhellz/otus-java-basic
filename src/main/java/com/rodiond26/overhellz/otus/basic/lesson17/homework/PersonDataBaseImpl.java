package com.rodiond26.overhellz.otus.basic.lesson17.homework;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBaseImpl implements PersonDataBase<Person> {

    private final Map<Long, Person> persons = new HashMap<>();

    @Override
    public Person findById(Long id) {
        return id == null ? null : persons.get(id);
    }

    @Override
    public void add(Person person) {
        if (person != null) {
            persons.put(person.getId(), person);
        }
    }

    @Override
    public boolean isManager(Person person) {
        return person != null
                && person.getPosition() != null
                && MANAGER_POSITIONS.contains(person.getPosition());
    }

    @Override
    public boolean isEmployee(Long id) {
        return id != null
                && persons.containsKey(id)
                && !isManager(persons.get(id));
    }
}
