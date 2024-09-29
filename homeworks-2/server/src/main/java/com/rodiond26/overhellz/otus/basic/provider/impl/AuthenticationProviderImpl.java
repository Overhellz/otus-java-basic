package com.rodiond26.overhellz.otus.basic.provider.impl;

import com.rodiond26.overhellz.otus.basic.handler.ClientHandler;
import com.rodiond26.overhellz.otus.basic.model.UserProfile;
import com.rodiond26.overhellz.otus.basic.provider.AuthenticationProvider;
import com.rodiond26.overhellz.otus.basic.server.Server;
import com.rodiond26.overhellz.otus.basic.service.UserProfileService;
import lombok.Setter;

import java.util.Optional;

import static com.rodiond26.overhellz.otus.basic.model.UserRole.USER;

public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final UserProfileService userProfileService;

    @Setter
    private Server server;

    public AuthenticationProviderImpl(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @Override
    public boolean register(ClientHandler clientHandler,
                            String userLogin,
                            String userPassword,
                            String userName) {

        String login = purify(userLogin);
        String password = purify(userPassword);
        String name = purify(userName);

        if (isIncorrectLength(login, LOGIN_MIN_LENGTH)) {
            String message = "Длина логина должна быть не менее " + LOGIN_MIN_LENGTH + " символов";
            return sendIsNotValidatedMessage(clientHandler, message);
        }

        if (isIncorrectLength(password, PASSWORD_MIN_LENGTH)) {
            String message = "Длина пароля должна быть не менее " + LOGIN_MIN_LENGTH + " символов";
            return sendIsNotValidatedMessage(clientHandler, message);
        }

        if (isIncorrectLength(name, USERNAME_MIN_LENGTH)) {
            String message = "Длина имени пользователя должна быть не менее " + LOGIN_MIN_LENGTH + " символов";
            return sendIsNotValidatedMessage(clientHandler, message);
        }

        if (userProfileService.isLoginAlreadyExist(login)) {
            String message = "Логин " + login + " уже занят";
            return sendIsNotValidatedMessage(clientHandler, message);
        }

        if (userProfileService.isUserNameAlreadyExist(userName)) {
            String message = "Имя пользователя " + login + " уже занято";
            return sendIsNotValidatedMessage(clientHandler, message);
        }

        userProfileService.add(new UserProfile(login, password, name, USER));
        clientHandler.setUsername(name);
        server.subscribe(clientHandler);
        clientHandler.sendMessage("/regok " + name);

        return true;
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler,
                                String userLogin,
                                String userPassword) {

        String login = purify(userLogin);
        String password = purify(userPassword);

        if (isIncorrectLength(login, LOGIN_MIN_LENGTH)) {
            return sendIsNotValidatedMessage(clientHandler, INCORRECT_LOGIN_OR_PASSWORD_MESSAGE);
        }

        Optional<UserProfile> userProfileOptional = userProfileService.findByLogin(login);
        if (userProfileOptional.isEmpty()) {
            return sendIsNotValidatedMessage(clientHandler, INCORRECT_LOGIN_OR_PASSWORD_MESSAGE);
        }

        if (!userProfileOptional.get().getPassword().equals(password)) {
            return sendIsNotValidatedMessage(clientHandler, INCORRECT_LOGIN_OR_PASSWORD_MESSAGE);
        }

        String userName = userProfileOptional.get().getName();
        if (server.isUserIsConnected(userName)) {
            return sendIsNotValidatedMessage(clientHandler, USER_IS_ALREADY_CONNECTED_MESSAGE);
        }

        clientHandler.setUsername(userName);
        server.subscribe(clientHandler);
        clientHandler.sendMessage("/authok " + userName);
        return true;
    }

    private boolean sendIsNotValidatedMessage(ClientHandler clientHandler, String message) {
        System.err.println(message);
        clientHandler.sendMessage(message);
        return false;
    }

    private boolean isIncorrectLength(String str, int minLength) {
        return str.length() < minLength;
    }

    private String purify(String str) {
        return isEmpty(str) ? "" : str.trim();
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
