package com.lysenkova.soapstore.dao.mapper;

import com.lysenkova.soapstore.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper  {
    public User mapRow(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
