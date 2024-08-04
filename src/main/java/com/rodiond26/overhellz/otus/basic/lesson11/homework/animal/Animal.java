package com.rodiond26.overhellz.otus.basic.lesson11.homework.animal;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

@AllArgsConstructor
@Getter
public abstract class Animal {

    /**
     * Затраты выносливости для всех животных во время бега, усл. ед.
     */
    public static final int ANIMAL_RUNNING_ENDURANCE = 1;

    /**
     * Имя
     */
    String name;

    /**
     * Скорость бега, м/с
     */
    int runningSpeed;

    /**
     * Скорость плавания, м/с
     */
    int swimmingSpeed;

    /**
     * Выносливость, усл. ед.
     */
    int endurance;

    /**
     * Состояние усталости
     */
    boolean isTired;

    /**
     * Затраты выносливости животного во время бега, усл. ед.
     */
    int runningEndurance;

    /**
     * Затраты выносливости животного во время плавания, усл. ед.
     */
    int swimmingEndurance;

    /**
     * Возвращает время, за которое животное пробежало расстояние distance
     *
     * @param distance расстояние
     * @return время
     */
    public float run(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Дистанция должна быть больше ноля");
        }

        if (runningSpeed <= 0 || runningEndurance <= 0) {
            log("Животное не умеет бегать");
            return -1.0f;
        }

        if (isTired) {
            log("Животное устало и не может бежать");
            endurance = 0;
            return -1;
        }

        int enduranceForDistance = distance / runningEndurance;
        if (enduranceForDistance >= endurance) {
            isTired = true;
            endurance = 0;
            log("Животное устало и не может бегать");
            return -1;
        }

        float time = (float) distance / runningSpeed;
        endurance -= enduranceForDistance;
        log(String.format("Животное пробежало и потратило %d ед. выносливости за %f секунд", endurance, time));
        return time;
    }

    /**
     * Возвращает время, за которое животное проплыло расстояние distance
     *
     * @param distance расстояние
     * @return время
     */
    public float swim(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Дистанция должна быть больше ноля");
        }

        if (swimmingSpeed <= 0 || swimmingEndurance <= 0) {
            log("Животное не умеет плавать");
            return -1.0f;
        }

        if (isTired) {
            log("Животное устало и не может плавать");
            return -1.0f;
        }

        int enduranceForDistance = distance / swimmingEndurance;
        if (enduranceForDistance >= endurance) {
            endurance = 0;
            isTired = true;
            log("Животное устало и не может плавать");
            return -1;
        }

        float time = (float) distance / runningSpeed;
        endurance -= enduranceForDistance;
        log(String.format("Животное проплыло и потратило %d ед. выносливости за %f секунд", endurance, time));
        return time;
    }

    /**
     * Возвращает информацию о состоянии животного
     */
    public abstract void info();
}
