package com.lysenkova.soapstore.service.impl;

import com.lysenkova.soapstore.entity.User;
import com.lysenkova.soapstore.service.SecurityService;
import com.lysenkova.soapstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.UUID;

public class SecurityServiceImpl implements SecurityService {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserService userService;

    @Override
    public Optional<String> getToken(String login, String password) {
        LOGGER.info("User with login {} trying to log in", login);
        User user = userService.getById();
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                LOGGER.info("User {} has logged in.", user.getLogin());
                String uuid = UUID.randomUUID().toString();
                return Optional.of(uuid);
            }
        return Optional.empty();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
