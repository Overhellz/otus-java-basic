package com.rodiond26.overhellz.otus.basic.service;

import com.rodiond26.overhellz.otus.basic.model.UserProfile;

public interface UserProfileService {

    boolean isLoginAlreadyExist(String login);

    boolean isUserNameAlreadyExist(String username);

    void add(UserProfile userProfile);
}
