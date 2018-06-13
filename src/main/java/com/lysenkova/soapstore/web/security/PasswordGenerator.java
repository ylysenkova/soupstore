package com.lysenkova.soapstore.web.security;

import com.google.common.base.Strings;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;

import static com.google.common.base.Preconditions.checkNotNull;

public class PasswordGenerator {
    private final SecureRandom random = new SecureRandom();
    private final int SALT_LENGTH = 10;

    public String hashPassword(String password) {
        checkNotNull(password);
//        String salt = getSalt();
        return getHash(password);
    }
//
//    private String getSalt() {
//        byte[] saltBytes = new byte[SALT_LENGTH];
//        random.nextBytes(saltBytes);
//        return Arrays.toString(saltBytes);
//    }

    private String getHash(String password) {
        return Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
    }
}
