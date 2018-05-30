package com.lysenkova.soapstore.service;

import com.lysenkova.soapstore.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById();
}
