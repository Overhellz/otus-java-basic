package com.rodiond26.overhellz.otus.basic.lesson15.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static com.rodiond26.overhellz.otus.basic.utils.CollectionUtil.isEmpty;
import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

/**
 * Методы для работы с классом Employee
 */
public class EmployeeUtil {

    /**
     * Возвращает список имен из списка сотрудников
     */
    public List<String> getNames(List<Employee> employees) {
        if (isEmpty(employees)) {
            return Collections.emptyList();
        }

        List<String> resultList = new ArrayList<>(employees.size());
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            if (isEmpty(employee.getName())) {
                continue;
            }

            resultList.add(employee.getName());
        }
        return resultList;
    }

    /**
     * Возвращает список сотрудников по условию
     */
    public List<Employee> getEmployees(List<Employee> employees, Predicate<Employee> predicate) {
        if (isEmpty(employees)) {
            return Collections.emptyList();
        }

        List<Employee> resultList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (predicate.test(employee)) {
                resultList.add(employee);
            }
        }
        return resultList;
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
}
