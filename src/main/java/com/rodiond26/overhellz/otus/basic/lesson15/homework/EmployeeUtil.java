package com.rodiond26.overhellz.otus.basic.lesson15.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.rodiond26.overhellz.otus.basic.utils.CollectionUtil.isEmpty;

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
     * Возвращает список сотрудников из списка employees,
     * возраст которых больше или равен minAge
     */
    public List<Employee> getEmployeesOlder(List<Employee> employees, double minAge, boolean isGreaterOrEqualsMinAge) {
        if (isEmpty(employees)) {
            return Collections.emptyList();
        }

        for (Iterator<Employee> iterator = employees.listIterator(); iterator.hasNext(); ) {
            Employee employee = iterator.next();
            if (employee == null) {
                iterator.remove();
                continue;
            }

            if (employee.getAge() - minAge >= 0 == isGreaterOrEqualsMinAge) {
                iterator.remove();
            }
        }
        return employees;
    }

    /**
     * Возвращает средний возраст сотрудников из списка employees
     */
    public double getAverageAge(List<Employee> employees) {
        if (isEmpty(employees)) {
            return 0;
        }

        double ageSum = 0;
        int count = 0;

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            ageSum += employee.getAge();
            count++;
        }

        return count == 0 ? 0 : ageSum / count;
    }

    /**
     * Возвращает список сотрудников из списка employees, которые старше среднего возраста сотрудников из списка employees
     * // TODO
     */
}
