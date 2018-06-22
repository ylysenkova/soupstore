package com.lysenkova.soapstore.web.security;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

import static com.google.common.base.Preconditions.checkNotNull;

public class PasswordGenerator {

    public String hashPassword(String password) {
        checkNotNull(password);
        return getHash(password);
    }

    private String getHash(String password) {
        return Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
    }
}
