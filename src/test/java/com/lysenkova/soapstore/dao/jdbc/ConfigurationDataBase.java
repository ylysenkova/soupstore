package com.lysenkova.soapstore.dao.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class ConfigurationDataBase {
    public MysqlDataSource injectDataSource() throws IOException {
        String propertiesUrl = "/database.properties";
        Properties properties = new Properties();
        properties.load(String.class.getResourceAsStream(propertiesUrl));
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(properties.getProperty("database.url"));
        dataSource.setUser(properties.getProperty("database.username"));
        dataSource.setPassword(properties.getProperty("database.password"));
        return dataSource;
    }
}
