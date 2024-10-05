package com.rodiond26.overhellz.otus.basic.repository.script;

import java.util.List;

public final class SqlInitScript {
    private SqlInitScript() {
    }

    public static final String CREATE_SCHEMA = """
            CREATE SCHEMA IF NOT EXISTS homework
            """;

    public static final String DROP_TABLE = """
            DROP TABLE IF EXISTS homework.users CASCADE
            """;

    public static final String DROP_ROLE_ENUM = """
            DROP TYPE IF EXISTS homework.user_role;
            """;

    public static final String CREATE_ROLE_ENUM = """
            CREATE TYPE homework.user_role AS ENUM ('ADMIN', 'USER')
            """;

    public static final String CREATE_TABLE = """
            CREATE TABLE homework.users (
                user_id  SERIAL              NOT NULL,
                login    VARCHAR(16)         NOT NULL,
                pass     VARCHAR(16)         NOT NULL,
                name     VARCHAR(16)         NOT NULL,
                role     homework.USER_ROLE  NOT NULL  DEFAULT 'USER'
            )
            """;

    public static final String ALTER_TABLE = """
            ALTER TABLE ONLY homework.users
            ADD CONSTRAINT pk_users PRIMARY KEY (user_id)
            """;

    public static final String INSERT_USERS = """
            INSERT INTO homework.users(login, pass, name)
            VALUES
            ('login1', 'password1', 'name1'),
            ('login2', 'password2', 'name2'),
            ('login3', 'password3', 'name3')
            """;

    public static final String INSERT_ADMINS = """
            INSERT INTO homework.users(login, pass, name, role)
            VALUES
            ('admin1', 'password1', 'admin1', 'ADMIN'),
            ('admin2', 'password2', 'admin2', 'ADMIN')
            """;

    public static final List<String> INIT_SCRIPTS = List.of(
            CREATE_SCHEMA,

            DROP_TABLE,
            DROP_ROLE_ENUM,

            CREATE_ROLE_ENUM,
            CREATE_TABLE,
            ALTER_TABLE,

            INSERT_USERS,
            INSERT_ADMINS
    );
}
