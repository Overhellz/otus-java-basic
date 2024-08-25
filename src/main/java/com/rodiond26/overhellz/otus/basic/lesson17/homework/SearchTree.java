package com.rodiond26.overhellz.otus.basic.lesson17.homework;

import java.util.List;

public interface SearchTree<T> {

    /**
     * Возвращает элемент с помощью метода equals,
     * иначе возращает null
     *
     * @param element элемент, который нужно найти
     * @return element найденный элемент или null
     */
    T find(T element);

    /**
     * Возвращает отсортированный список элементов
     */
    List<T> getSortedList();
}
