package com.lysenkova.soapstore.dao.jdbc;

import com.lysenkova.soapstore.dao.UserDao;
import com.lysenkova.soapstore.dao.mapper.UserMapper;
import com.lysenkova.soapstore.entity.User;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDao implements UserDao {
    private final static String GET_ALL_USERS_SQL = "select id, login, password from users";
    private final static String GET_USER_BY_LOGIN = "select id, login, password from users where login = ?";

    private final UserMapper USER_MAPPER = new UserMapper();
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private DataSource dataSource;

    @Override
    public List<User> getAll() {
        LOGGER.info("Getting all users is started.");
        List<User> users = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_USERS_SQL)) {

            while (resultSet.next()) {
                User user = USER_MAPPER.mapRow(resultSet);
                users.add(user);
            }
            LOGGER.trace("Users are got {}", users);
        } catch (SQLException e) {
            LOGGER.error("SQL error during getting users.");
            throw new RuntimeException("SQL error during getting users.", e);
        }
        return users;
    }

    @Override
    public User getById(String login) {
        LOGGER.info("Getting user by login is started.");
        User user = new User();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN)) {
            preparedStatement.setString(1, user.getLogin());
            LOGGER.info("User with login: {} is got", user.getLogin());
        } catch (SQLException e) {
            LOGGER.error("Error during getting user by login.");
            throw new RuntimeException("Error during getting user by login.", e);
        }
        return user;
    }

    public void setDataSource(MysqlDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
