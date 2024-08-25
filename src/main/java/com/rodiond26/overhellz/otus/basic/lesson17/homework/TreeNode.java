package com.rodiond26.overhellz.otus.basic.lesson17.homework;

import lombok.Data;

import java.util.List;

@Data
public class TreeNode<T extends Comparable<T>> {

    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    /**
     * Возвращает двоичное дерево из отсортированного списка list
     *
     * @param list отсортированный список
     * @return двоичное дерево
     */
    public TreeNode<T> toTreeNode(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return toTreeNode(list, 0, list.size() - 1);
    }

    /**
     * Возвращает двоичное дерево из отсортированного списка list в указанном диапазоне индексов
     *
     * @param list  отсортированный список
     * @param start индекс первого элемента списка
     * @param end   индекс последнего элемента списка
     * @return двоичное дерево
     */
    public TreeNode<T> toTreeNode(List<T> list, int start, int end) {
        if (start > end) {
            return null;
        }

        int middle = start + (end - start) / 2;
        TreeNode<T> root = new TreeNode<>();
        root.setValue(list.get(middle));
        root.setLeft(toTreeNode(list, start, middle - 1));
        root.setRight(toTreeNode(list, middle + 1, end));
        return root;
    }
}
