package com.rodiond26.overhellz.otus.basic.lesson06;

public class Basket {

    private String[] items = new String[5];

    public void add(String item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                System.out.println("в рюкзак положили предмет: " + items[i]);
                return;
            }
        }
        System.out.println("в рюкзакe больше нет места! ");
    }

    public void remove(String item) {
        for (int i = 0; i < items.length; i++) {
            if (item.equals(items[i])) {
                items[i] = null;
                System.out.println("Из рюкзака выложили предмет: " + item);
                return;
            }
        }
        System.out.println("В рюкзаке нет такого предмета!");
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.print("]");
    }

    public int count() {
        int counter = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                counter++;
            }
        }
        return counter;
    }
}
