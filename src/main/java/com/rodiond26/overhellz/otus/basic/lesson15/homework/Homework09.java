package com.rodiond26.overhellz.otus.basic.lesson15.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

public class Homework09 {

    public static void main(String[] args) {

        ListUtil listUtil = new ListUtil();

        List<Integer> dozen = listUtil.makeSequence(1, 12);
        log(dozen.toString());

        int sumOfElementsGreater5 = listUtil.sumIfElementGreater5(dozen);
        log("" + sumOfElementsGreater5);

        listUtil.fillList(dozen, 13);
        log(dozen.toString());

        listUtil.addDeltaToEach(dozen, 6);
        log(dozen.toString());

        EmployeeUtil employeeUtil = new EmployeeUtil();

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Анна", 15),
                new Employee("Александр", 40),
                null,
                new Employee("Наташа", 33),
                new Employee("Николай", 50),
                null,
                new Employee("Сергей", 18),
                new Employee("Сергей", 17)
        ));
        employees.add(null);
        employees.add(new Employee("Семен", 27));

        List<String> employeeNames = employeeUtil.getNames(employees);
        log(employeeNames.toString());

        List<Employee> adultEmployees = employeeUtil.getEmployeesOlder(employees, 18);
        log(adultEmployees.toString());

        List<Employee> employeesOlderAverageAge = employeeUtil.getEmployeesOlderAverageAge(employees);
        log(employeesOlderAverageAge.toString());

        Employee youngestEmployee = employeeUtil.getYoungest(employees);
        log(String.valueOf(youngestEmployee));
    }
}
