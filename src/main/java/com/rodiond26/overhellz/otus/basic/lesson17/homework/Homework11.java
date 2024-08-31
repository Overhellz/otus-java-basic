package com.rodiond26.overhellz.otus.basic.lesson17.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;
import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.toJsonOrToString;

public class Homework11 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i);
        }
        TreeNode<Integer> treeNode = new TreeNode<>();
        TreeNode<Integer> integerTreeNode = treeNode.toTreeNode(list);
        log(toJsonOrToString(integerTreeNode));

        Random random = new Random();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            employees.add(
                    new Employee(
                            "LastName-" + random.nextInt(30),
                            "FirstName-" + random.nextInt(30),
                            random.nextInt(30 * 2)
                    )
            );
        }
        Collections.sort(employees);
        TreeNode<Employee> treeNode1 =  new TreeNode<>();
        TreeNode<Employee> employeeTreeNode = treeNode1.toTreeNode(employees);
        log(toJsonOrToString(employeeTreeNode));
    }
}
