package com.rodiond26.overhellz.otus.basic.service;

import com.rodiond26.overhellz.otus.basic.model.UserProfile;

import java.util.Optional;

public interface UserProfileService {

    boolean isLoginAlreadyExist(String login);

    boolean isUserNameAlreadyExist(String username);

    void add(UserProfile userProfile);

    Optional<UserProfile> findByLogin(String login);
}
