package com.rodiond26.overhellz.otus.basic.repository.script;

public final class SqlCrudScript {
    private SqlCrudScript() {
    }

    public static final String SELECT_ALL_USERS = """
            SELECT user_id, login, pass, name, role
              FROM homework.users
            """;

    public static final String FIND_USER_BY_NAME = """
            SELECT user_id, login, pass, name, role
              FROM homework.users
             WHERE name = ?
            """;

    public static final String FIND_USER_BY_LOGIN = """
            SELECT user_id, login, pass, name, role
              FROM homework.users
             WHERE login = ?
            """;

    public static final String INSERT_NEW_USER = """
            INSERT INTO homework.users(login, pass, name, role)
            VALUES (?, ?, ?, ?::homework.user_role)
            """;
}
