package com.rodiond26.overhellz.otus.basic.lesson13.homework.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Тип местности
 */
@RequiredArgsConstructor
@Getter
public enum TerrainType {

    DENSE_FOREST("Густой лес"),
    PLAIN("Равнина"),
    SWAMP("Болото");

    private final String type;
}
