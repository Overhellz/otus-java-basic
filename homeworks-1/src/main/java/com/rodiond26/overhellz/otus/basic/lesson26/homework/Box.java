package com.rodiond26.overhellz.otus.basic.lesson26.homework;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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

    public static <T> void move(Box<? super Fruit> dest, Box<? extends Fruit> src) {
        int srcSize = src.getList().size();
        ListIterator<? extends Fruit> srcIterator = src.getList().listIterator();

        for (int i = 0; i < srcSize; i++) {
            dest.getList().add(srcIterator.next());
            srcIterator.remove();
        }
    }

    public boolean contains(T t) {
        return this.list.contains(t);
    }

    public List<T> getAll() {
        return this.list;
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
