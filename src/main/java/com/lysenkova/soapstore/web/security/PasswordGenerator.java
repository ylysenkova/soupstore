package com.lysenkova.soapstore.web.security;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

import static com.google.common.base.Preconditions.checkNotNull;

public class PasswordGenerator {

    public String hashPassword(String password, String salt) {
        checkNotNull(password);
        return getHash(password, salt);
    }

    private String getHash(String password, String salt) {
        return Hashing.sha256().hashString(salt + password, StandardCharsets.UTF_8).toString();
    }
}
