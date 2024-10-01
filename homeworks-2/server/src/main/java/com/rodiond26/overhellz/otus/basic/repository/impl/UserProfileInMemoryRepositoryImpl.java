package com.rodiond26.overhellz.otus.basic.repository.impl;

import com.rodiond26.overhellz.otus.basic.model.UserProfile;
import com.rodiond26.overhellz.otus.basic.repository.UserProfileRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.rodiond26.overhellz.otus.basic.model.UserRole.ADMIN;
import static com.rodiond26.overhellz.otus.basic.model.UserRole.USER;

public class UserProfileInMemoryRepositoryImpl implements UserProfileRepository {

    private final List<UserProfile> userProfiles;

    public UserProfileInMemoryRepositoryImpl() {
        userProfiles = new ArrayList<>(List.of(
                new UserProfile("login1", "password1", "name1", USER),
                new UserProfile("login2", "password2", "name2", USER),
                new UserProfile("login3", "password3", "name3", USER),
                new UserProfile("admin1", "password1", "admin1", ADMIN),
                new UserProfile("admin2", "password2", "admin2", ADMIN)
        ));
    }

    @Override
    public List<UserProfile> findAll() {
        return userProfiles;
    }

    @Override
    public Optional<UserProfile> findByName(String name) {
        return userProfiles.stream()
                .filter(profile -> profile.getName().equals(name))
                .findFirst();
    }

    @Override
    public Optional<UserProfile> findByLogin(String login) {
        return userProfiles.stream()
                .filter(profile -> profile.getLogin().equals(login))
                .findFirst();
    }

    @Override
    public void add(UserProfile userProfile) {
        userProfiles.add(userProfile);
    }
}
