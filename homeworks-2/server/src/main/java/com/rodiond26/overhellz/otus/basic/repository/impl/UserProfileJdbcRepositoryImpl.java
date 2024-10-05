package com.rodiond26.overhellz.otus.basic.repository.impl;

import com.rodiond26.overhellz.otus.basic.config.PostgreSqlDbConfig;
import com.rodiond26.overhellz.otus.basic.model.UserProfile;
import com.rodiond26.overhellz.otus.basic.repository.UserProfileRepository;
import com.rodiond26.overhellz.otus.basic.repository.script.SqlInitScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class UserProfileJdbcRepositoryImpl implements UserProfileRepository {

    private final PostgreSqlDbConfig config;
    private Connection connection;

    public UserProfileJdbcRepositoryImpl(PostgreSqlDbConfig config) throws SQLException {
        this.config = config;
        connection = DriverManager.getConnection(config.getDatabaseUrl(), config.getUserName(), config.getUserPassword());
        if (connection != null) {
            System.out.println("Успешное подключение к базе данных: " + config.getDatabaseUrl());
        }

        if (config.isNeedToInitialize()) {
            initialize();
            System.out.println("База данных проинициализирована");
        }
    }

    private void initialize() {
        try (Statement statement = connection.createStatement()) {
            for (String script : SqlInitScript.INIT_SCRIPTS) {
                statement.addBatch(script);
            }
            statement.executeBatch();
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при инициализации базы данных");
            e.printStackTrace();
        }
    }

    @Override
    public List<UserProfile> findAll() {
        // TODO
        return List.of();
    }

    @Override
    public Optional<UserProfile> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<UserProfile> findByLogin(String login) {
        return Optional.empty();
    }

    @Override
    public void add(UserProfile userProfile) {

    }
}
