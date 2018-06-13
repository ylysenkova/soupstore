package com.lysenkova.soapstore.web.security;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordGeneratorTest {

    @Test
    public void hashPassword() {
        String password = "notmain44";
        String expected = "d5c224cbd4d1dafdf186d0e6de515ac46027373a949613ff51d434cb74f88f41";
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String actual = passwordGenerator.hashPassword(password);
//        System.out.println(actual);
        assertEquals(expected, actual);
    }
}