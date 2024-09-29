package com.rodiond26.overhellz.otus.basic.lesson26.homework;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Box<T extends Fruit> implements Comparable<Box<Fruit>> {

    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void put(T t) {
        this.list.add(t);
    }

    public void putAll(List<T> list) {
        this.list.addAll(list);
    }

    public T get(T t) {
        return this.list.stream()
                .filter(fruit -> fruit.equals(t))
                .findAny()
                .orElse(null);
    }

    public List<T> getAll() {
        List<T> result = this.list;
        this.list = new ArrayList<>();
        return result;
    }

    public int getWeight() {
        return list.stream()
                .mapToInt(Fruit::getWeight)
                .sum();
    }

    @Override
    public int compareTo(Box other) {
        return Integer.compare(this.getWeight(), other.getWeight());
    }
}
