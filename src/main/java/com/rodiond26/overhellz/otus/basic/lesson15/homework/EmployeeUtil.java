package com.rodiond26.overhellz.otus.basic.lesson15.homework;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.rodiond26.overhellz.otus.basic.utils.CollectionUtil.isEmpty;
import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

/**
 * Методы для работы с классом Employee
 */
public final class EmployeeUtil {

    /**
     * Возвращает список имен из списка сотрудников
     */
    public List<String> getNames(List<Employee> employees) {
        if (isEmpty(employees)) {
            return Collections.emptyList();
        }

        return employees.stream()
                .filter(Objects::nonNull)
                .map(Employee::getName)
                .filter(name -> !isEmpty(name))
                .collect(Collectors.toList());
    }

    /**
     * Возвращает список сотрудников по условию
     */
    public List<Employee> getEmployees(List<Employee> employees, Predicate<Employee> predicate) {
        if (isEmpty(employees)) {
            return Collections.emptyList();
        }
        return employees.stream()
                .filter(Objects::nonNull)
                .filter(predicate)
                .collect(Collectors.toList());
    }

    /**
     * Возвращает список сотрудников из списка employees,
     * возраст которых больше или равен minAge
     */
    public List<Employee> getEmployeesOlder(List<Employee> employees, double minAge) {
        return getEmployees(
                employees,
                employee -> employee.getAge() - minAge >= 0
        );
    }

    /**
     * Возвращает список сотрудников из списка employees, которые старше среднего возраста сотрудников из списка employees
     */
    public List<Employee> getEmployeesOlderAverageAge(List<Employee> employees) {
        double averageAge = getAverageAge(employees);

        return getEmployees(
                employees,
                employee -> employee.getAge() - averageAge > 0
        );
    }

    /**
     * Возвращает средний возраст сотрудников из списка employees
     */
    public double getAverageAge(List<Employee> employees) {
        double averageAge = 0;
        if (isEmpty(employees)) {
            return averageAge;
        }

        averageAge = employees.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Employee::getAge)
                .average()
                .orElse(0);

        log(String.format("Средний возраст сотрудников: %.1f лет", averageAge));
        return averageAge;
    }

    /**
     * Возвращает самого молодого сотрудника из списка employees
     */
    public Employee getYoungest(List<Employee> employees) {
        if (isEmpty(employees)) {
            log("В списке нет сотрудников");
            return null;
        }

        Employee result = employees.stream()
                .filter(Objects::nonNull)
                .filter(employee -> !isEmpty(employee.getName()))
                .min(Comparator.comparing(Employee::getAge))
                .orElse(null);

        if (result == null) {
            log("В списке находятся некорректные объекты");
        }
        return result;
    }
}
