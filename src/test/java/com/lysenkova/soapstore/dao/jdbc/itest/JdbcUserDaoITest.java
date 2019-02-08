package com.lysenkova.soapstore.dao.jdbc.itest;

import com.lysenkova.soapstore.dao.jdbc.JdbcUserDao;
import com.lysenkova.soapstore.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class JdbcUserDaoITest {
    private JdbcUserDao userDao = new JdbcUserDao();

    @Before
    public void before() throws IOException {
        ConfigurationDataBase config = new ConfigurationDataBase();
        userDao.setDataSource(config.getDataSource());
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