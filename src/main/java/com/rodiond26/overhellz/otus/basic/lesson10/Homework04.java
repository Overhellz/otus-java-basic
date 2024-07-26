package com.rodiond26.overhellz.otus.basic.lesson10;

public class Homework04 {

    /**
     * Домашнее задание
     * Введение в ООП
     * Цель домашнего задания: научиться на базовом уровне работать с классами и объектами.
     * ● Создайте класс Пользователь (User) с полями: фамилия, имя, отчество, год рождения, email;
     * ● Реализуйте у класса конструктор, позволяющий заполнять эти поля при создании объекта;
     * ● В классе Пользователь реализуйте метод, выводящий в консоль информацию о пользователе в виде:
     * ФИО: фамилия имя отчество
     * Год рождения: год рождения
     * e-mail: email
     * ● В методе main() Main класса создайте массив из 10 пользователей и заполните его объектами и с помощью
     * цикла выведите информацию только о пользователях старше 40 лет.
     *
     *
     * ● Попробуйте реализовать класс по его описанию: объекты класса Коробка должны иметь размеры и цвет.
     * Коробку можно открывать и закрывать. Коробку можно перекрашивать. Изменить размер коробки после
     * создания нельзя. У коробки должен быть метод, печатающий информацию о ней в консоль. В коробку можно
     * складывать предмет (если в ней нет предмета), или выкидывать его оттуда (только если предмет в ней есть),
     * только при условии что коробка открыта (предметом читаем просто строку). Выполнение методов должно
     * сопровождаться выводом сообщений в консоль.
     */
    public static void main(String[] args) {
        User[] users = {
                new User(),
                new User(),
                new User(),
                new User(),
                new User(),
                new User(),
                new User(),
                new User(),
                new User(),
                new User(),
        };

        int currentYear = 2024;
        for (User user : users) {
            if (currentYear - user.getBirthYear() > 40) {
                System.out.println(user);
            }
        }
    }
}
