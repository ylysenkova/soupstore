package com.lysenkova.soapstore.service;

import java.util.Optional;

public interface SecurityService {
    Optional<String> getToken(String login, String password);
}
