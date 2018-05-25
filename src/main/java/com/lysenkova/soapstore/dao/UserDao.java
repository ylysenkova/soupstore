package com.lysenkova.soapstore.dao;

import com.lysenkova.soapstore.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
}
