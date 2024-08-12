package com.rodiond26.overhellz.otus.basic.lesson13.homework;

import com.rodiond26.overhellz.otus.basic.lesson13.homework.transport.Transport;
import lombok.Getter;
import lombok.Setter;

public class Human {
    @Getter
    private final String name;

    @Getter
    @Setter
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }
}
