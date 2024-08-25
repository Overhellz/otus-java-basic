package com.rodiond26.overhellz.otus.basic.lesson17.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Сотрудник
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee implements Comparable<Employee> {

    /**
     * Фамилия
     */
    @NonNull
    private String lastName;

    /**
     * Имя
     */
    @NonNull
    private String firstName;

    /**
     * Возраст
     */
    private int age;

    @Override
    public int compareTo(Employee other) {
        int result = this.lastName.compareTo(other.getLastName());
        if (result != 0) {
            return result;
        }

        result = this.firstName.compareTo(other.getFirstName());
        if (result != 0) {
            return result;
        }

        return this.age - other.getAge();
    }
}
