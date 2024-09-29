package com.rodiond26.overhellz.otus.basic.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProfile {

    private final String login;
    private String password;
    private String name;
    private UserRole role;
}
