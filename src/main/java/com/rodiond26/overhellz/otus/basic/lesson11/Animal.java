package com.rodiond26.overhellz.otus.basic.lesson11;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

@Getter
@AllArgsConstructor
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
    int runSpeed;

    /**
     * Скорость плавания, м/с
     */
    int swimSpeed;

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
        if (runSpeed <= 0 || runningEndurance <= 0) {
            throw new AnimalCannotRunException("Животное не умеет бегать");
        }

        if (isTired) {
            log("Животное устало и не может бежать");
            return -1;
        }

        int enduranceForDistance = distance / runningEndurance;
        if (enduranceForDistance >= endurance) {
            isTired = true;
            log("Животное устало и не может бежать");
            return -1;
        }

        float time = (float) distance / runSpeed;
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
        if (swimSpeed <= 0 || swimmingEndurance <= 0) {
            throw new AnimalCannotSwimException("Животное не умеет плавать");
        }

        if (isTired) {
            log("Животное устало и не может плавать");
            return -1;
        }

        int enduranceForDistance = distance / swimmingEndurance;
        if (enduranceForDistance >= endurance) {
            isTired = true;
            log("Животное устало и не может плавать");
            return -1;
        }

        float time = (float) distance / runSpeed;
        endurance -= enduranceForDistance;
        log(String.format("Животное проплыло и потратило %d ед. выносливости за %f секунд", endurance, time));
        return time;
    }

    public void info() {
        log(this.toString());
    }

    @Override
    public String toString() { // TODO fix
        return "Animal{" +
                "name='" + name + '\'' +
                ", runSpeed=" + runSpeed +
                ", swimSpeed=" + swimSpeed +
                ", endurance=" + endurance +
                ", isTired=" + isTired +
                ", runningEndurance=" + runningEndurance +
                ", swimmingEndurance=" + swimmingEndurance +
                '}';
    }
}
