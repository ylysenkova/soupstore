package com.lysenkova.soapstore.service.impl;

import com.lysenkova.soapstore.dao.UserDao;
import com.lysenkova.soapstore.entity.User;
import com.lysenkova.soapstore.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById() {
        return userDao.getById();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
