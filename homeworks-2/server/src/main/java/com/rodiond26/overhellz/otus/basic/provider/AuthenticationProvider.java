package com.rodiond26.overhellz.otus.basic.provider;

import com.rodiond26.overhellz.otus.basic.handler.ClientHandler;

public interface AuthenticationProvider {

    int LOGIN_MIN_LENGTH = 3;
    int PASSWORD_MIN_LENGTH = 6;
    int USERNAME_MIN_LENGTH = 3;

    boolean registerNewUser(ClientHandler clientHandler,
                            String userLogin,
                            String userPassword,
                            String userName);
}
