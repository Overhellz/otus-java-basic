package com.rodiond26.overhellz.otus.basic;

import com.rodiond26.overhellz.otus.basic.provider.impl.AuthenticationProviderImpl;
import com.rodiond26.overhellz.otus.basic.repository.UserProfileRepository;
import com.rodiond26.overhellz.otus.basic.repository.impl.UserProfileInMemoryRepositoryImpl;
import com.rodiond26.overhellz.otus.basic.server.Server;
import com.rodiond26.overhellz.otus.basic.service.UserProfileService;
import com.rodiond26.overhellz.otus.basic.service.impl.UserProfileServiceImpl;

public class ServerApplication {
    public static void main(String[] args) {
        UserProfileRepository userProfileRepository = new UserProfileInMemoryRepositoryImpl();
        UserProfileService userProfileService = new UserProfileServiceImpl(userProfileRepository);
        AuthenticationProviderImpl authenticationProvider = new AuthenticationProviderImpl(userProfileService);

        Server server = new Server(8888, authenticationProvider);
        authenticationProvider.setServer(server);

        server.start();
    }
}
