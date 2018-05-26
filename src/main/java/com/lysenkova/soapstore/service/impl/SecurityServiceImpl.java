package com.lysenkova.soapstore.service.impl;

import com.lysenkova.soapstore.entity.User;
import com.lysenkova.soapstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SecurityServiceImpl implements com.lysenkova.soapstore.service.SecurityService {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserService userService;
    @Override
    public UUID validateUser(Map<String, String> loginPasswordMap) {
        LOGGER.info("User with login {} trying to log in", loginPasswordMap.keySet());
        List<User> users = userService.getAll();
        for (User user : users) {
            for (Map.Entry<String, String> loginPassword : loginPasswordMap.entrySet()) {
                if(loginPassword.getKey().equals(user.getLogin()) && loginPassword.getValue().equals(user.getPassword())) {
                    LOGGER.info("User {} has logged in.", user.getLogin());
                    return UUID.randomUUID();
                }
            }

        }
        return null;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
