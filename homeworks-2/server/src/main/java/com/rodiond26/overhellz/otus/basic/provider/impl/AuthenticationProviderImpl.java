package com.rodiond26.overhellz.otus.basic.provider.impl;

import com.rodiond26.overhellz.otus.basic.handler.ClientHandler;
import com.rodiond26.overhellz.otus.basic.model.UserProfile;
import com.rodiond26.overhellz.otus.basic.provider.AuthenticationProvider;
import com.rodiond26.overhellz.otus.basic.server.Server;
import com.rodiond26.overhellz.otus.basic.service.UserProfileService;
import lombok.Setter;

import static com.rodiond26.overhellz.otus.basic.model.UserRole.USER;

public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final UserProfileService userProfileService;

    @Setter
    private Server server;

    public AuthenticationProviderImpl(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @Override
    public boolean registerNewUser(ClientHandler clientHandler,
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
            String message = "Длина логина должна быть не менее " + LOGIN_MIN_LENGTH + " символов";
            return sendIsNotValidatedMessage(clientHandler, message);
        }

        if (isIncorrectLength(name, USERNAME_MIN_LENGTH)) {
            String message = "Длина логина должна быть не менее " + LOGIN_MIN_LENGTH + " символов";
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
