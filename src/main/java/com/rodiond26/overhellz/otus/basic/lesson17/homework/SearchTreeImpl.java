package com.rodiond26.overhellz.otus.basic.lesson17.homework;

import java.util.List;

public class SearchTreeImpl implements SearchTree<Employee> {

    private TreeNode<Employee> employeeTreeNode;

    // TODO исправить
    public SearchTreeImpl(List<Employee> employees) {
        TreeNode<Employee> treeNode = new TreeNode<>();
        this.employeeTreeNode = treeNode.toTreeNode(employees);
    }

    // TODO исправить
    @Override
    public Employee find(Employee employee) {
        if (employeeTreeNode.getValue().compareTo(employee) == 0) {
            return employeeTreeNode.getValue();
        }
        if (employeeTreeNode.getValue().compareTo(employee) < 0) {
            return find(employeeTreeNode.getLeft().getValue());
        } else {
            return find(employeeTreeNode.getRight().getValue());
        }
    }

    @Override
    public List<Employee> getSortedList() {
        return List.of();
    }
}
