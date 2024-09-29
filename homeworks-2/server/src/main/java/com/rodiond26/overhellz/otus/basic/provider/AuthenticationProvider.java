package com.rodiond26.overhellz.otus.basic.provider;

import com.rodiond26.overhellz.otus.basic.handler.ClientHandler;

public interface AuthenticationProvider {

    int LOGIN_MIN_LENGTH = 3;
    int PASSWORD_MIN_LENGTH = 6;
    int USERNAME_MIN_LENGTH = 3;

    String INCORRECT_LOGIN_OR_PASSWORD_MESSAGE = "Некорректный логин/пароль";
    String USER_IS_ALREADY_CONNECTED_MESSAGE = "Учетная запись уже занята";

    boolean register(ClientHandler clientHandler,
                     String userLogin,
                     String userPassword,
                     String userName);

    boolean authenticate(ClientHandler clientHandler,
                         String login,
                         String password);
}
