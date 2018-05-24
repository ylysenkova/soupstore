package com.lysenkova.soapstore.dao.jdbc;

import com.lysenkova.soapstore.dao.ProductDao;
import com.lysenkova.soapstore.entity.Product;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;

public class JdbcProductDaoTest {

    @Test
    public void getAll() throws IOException {
        String propertiesUrl = "/db/database.properties";
        Properties properties = new Properties();
        properties.load(String.class.getResourceAsStream(propertiesUrl));

        JdbcProductDao productDao = new JdbcProductDao();
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(properties.getProperty("database.url"));
        dataSource.setUser(properties.getProperty("database.username"));
        dataSource.setPassword(properties.getProperty("database.password"));
        productDao.setDataSource(dataSource);

        assertNotNull(productDao.getAll());

    }
}