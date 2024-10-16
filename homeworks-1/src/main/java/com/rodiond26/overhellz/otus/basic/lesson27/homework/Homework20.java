package com.rodiond26.overhellz.otus.basic.lesson27.homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Homework20 {

    private static final Logger LOGGER = LogManager.getLogger(Homework20.class.getName());

    public static void main(String[] args) {
        LOGGER.debug("Старт приложения");
        new MainScenario().start();
        LOGGER.debug("Стоп приложения");
    }
}
