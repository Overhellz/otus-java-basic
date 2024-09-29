package com.rodiond26.overhellz.otus.basic.lesson26.homework;

import lombok.Data;

@Data
public class Fruit implements Comparable<Fruit> {

    private final int weight;

    @Override
    public int compareTo(Fruit other) {
        return Integer.compare(this.weight, other.getWeight());
    }

    @Override
    public String toString() {
        return "Fruit{weight=" + weight + '}';
    }
}
