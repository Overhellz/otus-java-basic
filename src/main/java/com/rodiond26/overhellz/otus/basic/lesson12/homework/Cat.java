package com.rodiond26.overhellz.otus.basic.lesson12.homework;

/**
 * Кот
 */
public class Cat {

    /**
     * Имя кота
     */
    private String name;

    /**
     * Аппетит кота
     */
    private int appetite;

    /**
     * Кот сыт (да/нет)
     */
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isFull() {
        return isFull;
    }

    /**
     * Кот ест из тарелки plate
     *
     * @param plate тарелка
     */
    public void eatFrom(Plate plate) {

    }
}
