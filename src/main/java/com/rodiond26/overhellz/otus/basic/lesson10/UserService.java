package com.rodiond26.overhellz.otus.basic.lesson10;

public interface UserService {

    User createRandomUser();
    User createRandomMaleUser();
    User createRandomFemaleUser();

    String getMaleLastName();
    String getMaleFirstName();
    String getMaleMiddleName();

    String getFemaleLastName();
    String getFemaleFirstName();
    String getFemaleMiddleName();

    int getUserBirthYear();
    String createUserEmail();
}
