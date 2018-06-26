package com.lysenkova.soapstore.web.security;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordGeneratorTest {

    @Test
    public void hashPassword() {
        String password = "notmain44";
        String salt = "75424845";
        String expected = "c43f93e65fd77e0acd94c9a56c7183918c16fb9a22420cdd6dce005cb227a3a3";
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String actual = passwordGenerator.hashPassword(password, salt);
        assertEquals(expected, actual);
    }
}