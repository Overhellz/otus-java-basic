package com.rodiond26.overhellz.otus.basic.lesson13.homework.transport;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.enums.TerrainType;

public class Horse implements Transport {
    @Override
    public boolean drive(int distance, TerrainType terrainType) {
        return false;
    }
}
