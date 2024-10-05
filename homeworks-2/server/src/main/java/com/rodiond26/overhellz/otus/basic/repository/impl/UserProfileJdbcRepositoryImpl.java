package com.rodiond26.overhellz.otus.basic.repository.impl;

import com.rodiond26.overhellz.otus.basic.config.PostgreSqlDbConfig;
import com.rodiond26.overhellz.otus.basic.model.UserProfile;
import com.rodiond26.overhellz.otus.basic.model.UserRole;
import com.rodiond26.overhellz.otus.basic.repository.UserProfileRepository;
import com.rodiond26.overhellz.otus.basic.repository.script.SqlInitScript;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.rodiond26.overhellz.otus.basic.repository.script.SqlCrudScript.*;

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
        List<UserProfile> resultList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS)) {
                while (resultSet.next()) {
                    String login = resultSet.getString("login");
                    String password = resultSet.getString("pass");
                    String name = resultSet.getString("name");
                    UserRole userRole = UserRole.valueOf(resultSet.getString("role"));
                    resultList.add(new UserProfile(login, password, name, userRole));
                }
            }
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при получении всех пользователей");
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public Optional<UserProfile> findByName(String name) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_NAME)) {
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String login = resultSet.getString("login");
                    String password = resultSet.getString("pass");
                    String userName = resultSet.getString("name");
                    UserRole userRole = UserRole.valueOf(resultSet.getString("role"));
                    return Optional.of(new UserProfile(login, password, userName, userRole));
                }
            }
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при получении пользователя по имени: " + name);
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserProfile> findByLogin(String login) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_LOGIN)) {
            preparedStatement.setString(1, login);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String userLogin = resultSet.getString("login");
                    String password = resultSet.getString("pass");
                    String userName = resultSet.getString("name");
                    UserRole userRole = UserRole.valueOf(resultSet.getString("role"));
                    return Optional.of(new UserProfile(userLogin, password, userName, userRole));
                }
            }
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при получении пользователя по логину: " + login);
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void add(UserProfile userProfile) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER)) {
            preparedStatement.setString(1, userProfile.getLogin());
            preparedStatement.setString(2, userProfile.getPassword());
            preparedStatement.setString(3, userProfile.getName());
            preparedStatement.setString(4, userProfile.getRole().name());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Добавлен новый пользователь: " + userProfile);
            }
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при добавлении пользователя: " + userProfile);
            e.printStackTrace();
        }
    }
}
