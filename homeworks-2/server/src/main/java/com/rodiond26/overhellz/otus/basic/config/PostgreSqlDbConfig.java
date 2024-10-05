package com.rodiond26.overhellz.otus.basic.config;

public final class PostgreSqlDbConfig {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String userName = "postgres";
    private final String userPassword = "postgres";
    private final boolean isNeedToInitialize = true;

    public String getDatabaseUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public boolean isNeedToInitialize() {
        return isNeedToInitialize;
    }
}
