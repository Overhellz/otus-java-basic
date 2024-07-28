package com.rodiond26.overhellz.otus.basic.lesson10;

public class SimpleBox {

    private final int length;
    private final int width;
    private final int height;
    private String color;
    private boolean isOpen = false;
    private String nestedObject;

    public SimpleBox(int length, int width, int height, String color) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public SimpleBox(int length, int width, int height) {
        this(length, width, height, "white");
    }

    /**
     * Открыть коробку
     */
    public void open() {
        this.isOpen = true;
        log("Коробка открыта.");
    }

    /**
     * Закрыть коробку
     */
    public void close() {
        this.isOpen = false;
        log("Коробка закрыта.");
    }

    /**
     * Поместить предмет в коробку
     */
    public void put(String thing) {
        if (!isOpen) {
            log("Нельзя положить предмет в коробку. Коробка закрыта.");
            return;
        }
        if (this.nestedObject != null) {
            log(String.format("Нельзя положить предмет в коробку. В коробке находится предмет %s", nestedObject));
            return;
        }
        this.nestedObject = thing;
        log(String.format("В коробку положили предмет %s", this.nestedObject));
    }

    /**
     * Взять предмет из коробки
     */
    public void getThing(String thing) {
        if (!isOpen) {
            log("Нельзя взять предмет из коробки. Коробка закрыта.");
            return;
        }
        if (nestedObject == null) {
            log("Нельзя взять предмет из коробки. Коробка пуста");
            return;
        }
        if (!thing.equalsIgnoreCase(nestedObject)) {
            log(String.format("Нельзя взять предмет %s из коробки. В коробке находится предмет %s", thing, nestedObject));
            return;
        }
        this.nestedObject = null;
        log(String.format("Из коробки взяли предмет %s. Коробка пуста", thing));
    }

    public void info() {
        System.out.println(this);
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getNestedObject() {
        return nestedObject;
    }

    @Override
    public String toString() {
        return String.format(
                "Коробка: длина = %d, ширина = %d, высота = %d, цвет = %s, открыта = %s\nПредмет в коробке: %s",
                this.length,
                this.width,
                this.height,
                this.color,
                this.isOpen ? "да" : "нет",
                this.nestedObject == null ? "отсутствует" : this.nestedObject
        );
    }

    private void log(String message) {
        System.out.println(message);
    }
}
