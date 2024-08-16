package com.rodiond26.overhellz.otus.basic.lesson15.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.rodiond26.overhellz.otus.basic.utils.CollectionUtil.isEmpty;

/**
 * Методы для работы со списками
 */
public class ListUtil {

    /**
     * Возвращает список целочисленных значений от min до max с шагом 1
     */
    public List<Integer> makeSequence(int min, int max) {
        if (min > max) {
            return Collections.emptyList();
        }

        int step = 1;
        List<Integer> resultList = new ArrayList<>(max - min);
        for (int i = min; i <= max; i += step) {
            resultList.add(i);
        }
        return resultList;
    }

    /**
     * Возвращает сумму элементов списка list, значение которых больше 5
     */
    public int sumIfElementGreater5(List<Integer> list) {
        if (isEmpty(list)) {
            return 0;
        }

        int minValue = 5;
        int sum = 0;
        for (Integer element : list) {
            if (element == null) {
                continue;
            }

            if (element > minValue) {
                sum += element;
            }
        }
        return sum;
    }

    /**
     * Принимаюет список list и заполняет его значениями value
     */
    public void fillList(List<Integer> list, int value) {
        if (isEmpty(list)) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            list.set(i, value);
        }
    }

    /**
     * Принимаюет список list и увеличивает значение каждого его элемента на delta
     */
    public void addDeltaToEach(List<Integer> list, int delta) {
        if (isEmpty(list)) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            // Если элемент списка равен null, то принимаем значение элемента равным 0 и добавляем к нему delta
            if (list.get(i) == null) {
                list.set(i, delta);
                continue;
            }
            list.set(i, list.get(i) + delta);
        }
    }
}
