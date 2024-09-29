package com.rodiond26.overhellz.otus.basic.repository;

import com.rodiond26.overhellz.otus.basic.model.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserProfileRepository {

    List<UserProfile> findAll();

    Optional<UserProfile> findByName(String name);

    Optional<UserProfile> findByLogin(String login);

    void add(UserProfile userProfile);
}
