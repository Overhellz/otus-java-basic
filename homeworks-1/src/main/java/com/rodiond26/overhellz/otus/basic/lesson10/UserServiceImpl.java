package com.rodiond26.overhellz.otus.basic.lesson10;

import java.util.Random;

public class UserServiceImpl implements UserService {

    private final Random random = new Random();

    private final String[] femaleFirstNames = {"Жанна", "Ольга", "Елена", "Алена", "Алиса"};
    private final String[] femaleLastNames = {"Иванова", "Петрова", "Сидорова", "Медведева", "Николаева"};
    private final String[] femaleMiddleNames = {"Николаевна", "Олеговна", "Александровна", "Борисовна", "Алексеевна"};

    private final String[] maleFirstNames = {"Александр", "Евгений", "Дмитрий", "Константин", "Григорий"};
    private final String[] maleLastNames = {"Иванов", "Петров", "Сидоров", "Медведев", "Николаев"};
    private final String[] maleMiddleNames = {"Николаевич", "Олегович", "Александрович", "Борисович", "Алексеевич"};

    @Override
    public User createRandomUser() {
        return random.nextBoolean() ? createRandomMaleUser() : createRandomFemaleUser();
    }

    @Override
    public User createRandomMaleUser() {
        return new User(
                getMaleLastName(),
                getMaleFirstName(),
                getMaleMiddleName(),
                getUserBirthYear(),
                createUserEmail()
        );
    }

    @Override
    public User createRandomFemaleUser() {
        return new User(
                getFemaleLastName(),
                getFemaleFirstName(),
                getFemaleMiddleName(),
                getUserBirthYear(),
                createUserEmail()
        );
    }

    @Override
    public String getMaleLastName() {
        return getRandomElement(this.maleLastNames);
    }

    @Override
    public String getMaleFirstName() {
        return getRandomElement(this.maleFirstNames);
    }

    @Override
    public String getMaleMiddleName() {
        return getRandomElement(this.maleMiddleNames);
    }

    @Override
    public String getFemaleLastName() {
        return getRandomElement(this.femaleLastNames);
    }

    @Override
    public String getFemaleFirstName() {
        return getRandomElement(this.femaleFirstNames);
    }

    @Override
    public String getFemaleMiddleName() {
        return getRandomElement(this.femaleMiddleNames);
    }

    @Override
    public int getUserBirthYear() {
        return 1970 + random.nextInt(40);
    }

    @Override
    public String createUserEmail() {
        return String.format(
                "%s@%s.%s",
                createRandomString(10),
                createRandomString(6),
                createRandomString(3)
        );
    }

    private String getRandomElement(String[] arr) {
        return arr == null || arr.length == 0
                ? ""
                : arr[random.nextInt(arr.length)];
    }

    private String createRandomString(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Длина строки должна быть больше 0");
        }

        char[] charArray = new char[length];
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = getRandomChar();
        }
        return new String(charArray);
    }

    private char getRandomChar() {
        // a = 97
        // z = 122
        // итого 26 символов
        return (char) (97 + random.nextInt(26));
    }
}
