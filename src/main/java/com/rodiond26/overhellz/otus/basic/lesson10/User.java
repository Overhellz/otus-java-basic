package com.rodiond26.overhellz.otus.basic.lesson10;

/**
 * Пользователь
 */
public class User {

    /**
     * Фамилия
     */
    private String lastname;

    /**
     * Имя
     */
    private String firstname;

    /**
     * Отчество
     */
    private String middleName;

    /**
     * Год рождения
     */
    private int birthYear;

    /**
     * email
     */
    private String email;

    public User() {
    }

    public User(String lastname, String firstname, String middleName, int birthYear, String email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.middleName = middleName;
        this.birthYear = birthYear;
        this.email = email;
    }

    @Override
    public String toString() {

        String sb = "ФИО: " +
                toStringNullable(this.lastname) +
                toStringNullable(this.firstname) +
                toStringNullable(this.firstname) +
                "\n" +
                "Год рождения: " +
                this.birthYear +
                "\n" +
                "e-mail: " +
                toStringNullable(this.email);
        return sb;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String toStringNullable(String str) {
        return str == null ? "<null>" : str;
    }
}
