package com.rodiond26.overhellz.otus.basic.service.impl;

import com.rodiond26.overhellz.otus.basic.model.UserProfile;
import com.rodiond26.overhellz.otus.basic.repository.UserProfileRepository;
import com.rodiond26.overhellz.otus.basic.service.UserProfileService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repository;

    @Override
    public boolean isLoginAlreadyExist(String login) {
        return repository.findByLogin(login).isPresent();
    }

    @Override
    public boolean isUserNameAlreadyExist(String username) {
        return repository.findByName(username).isPresent();
    }

    @Override
    public void add(UserProfile userProfile) {
        repository.add(userProfile);
    }
}
