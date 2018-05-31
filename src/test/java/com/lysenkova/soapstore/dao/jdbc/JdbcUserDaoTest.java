package com.lysenkova.soapstore.dao.jdbc;

import com.lysenkova.soapstore.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class JdbcUserDaoTest {
    private JdbcUserDao userDao = new JdbcUserDao();

    @Before
    public void before() throws IOException, SQLException {
        ConfigurationDataBase config = new ConfigurationDataBase();
        userDao.setDataSource(config.injectDataSource());
    }

    @Test
    public void getAll() {
        List<User> users = userDao.getAll();
        for (User user : users) {
            assertNotNull(user);
        }
    }

    @Test
    public void getByLogin() {
        User userTest = new User();
        userTest.setLogin("main");
        User user = userDao.getByLogin("main");
        assertEquals(userTest.getLogin(), user.getLogin());
    }
}