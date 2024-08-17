package com.rodiond26.overhellz.otus.basic.lesson16.homework;

import java.util.*;
import java.util.stream.Collectors;

import static com.rodiond26.overhellz.otus.basic.utils.ConsolePrinter.log;

/**
 * Класс для работы со списками телефонных номеров по имени
 */
public class PhoneBook {

    private final Map<String, Set<String>> phones;

    public PhoneBook() {
        this.phones = new HashMap<>();
    }

    /**
     * Добавление записи в телефонный справочник
     *
     * @param name        имя
     * @param phoneNumber телефонный номер (до 10 символов)
     */
    public void add(String name, String phoneNumber) {
        checkName(name);
        checkPhoneNumber(phoneNumber);

        if (!phones.containsKey(name)) {
            phones.put(name, new HashSet<>());
        }
        phones.get(name).add(phoneNumber);
    }

    /**
     * Поиск номеров телефонов в справочнике по имени
     *
     * @param name имя
     * @return список номеров телефонов
     */
    public Set<String> find(String name) {
        checkName(name);
        return phones.getOrDefault(name, Collections.emptySet());
    }

    /**
     * Проверка наличия номера телефона в справочнике
     *
     * @param phoneNumber телефонный номер (до 10 символов)
     * @return список номеров телефонов
     */
    public boolean containsPhoneNumber(String phoneNumber) {
        checkPhoneNumber(phoneNumber);

        List<String> names = phones.entrySet().stream()
                .filter(entry -> entry.getValue().contains(phoneNumber))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (names.isEmpty()) {
            log(String.format("Номер телефона [%s] не найден", phoneNumber));
            return false;
        } else {
            log(String.format("Номер телефона %s найден у владельцев %s", phoneNumber, names));
            return true;
        }
    }

    /**
     * Проверка значения имени перед работой со справочником
     */
    private void checkName(String name) {
        if (name == null || name.isBlank()) {
            // TODO fix
        }
    }

    /**
     * Проверка значения номера телефона перед работой со справочником
     */
    private void checkPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            // TODO fix
        }
    }

    @Override
    public String toString() {
        return "PhoneBook{phones=" + phones.keySet() + '}';
    }
}
