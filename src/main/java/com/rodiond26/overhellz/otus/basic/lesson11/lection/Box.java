package com.rodiond26.overhellz.otus.basic.lesson11.lection;

import java.util.Objects;

public class Box {

    private int size;
    private String color;
    private float weight;

    public Box(int size) {
        this.size = size;
        this.weight = (float) Math.random() * 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Box box = (Box) o;
        return size == box.size && Float.compare(box.weight, weight) == 0 && color.equals(box.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, color, weight);
    }
}
