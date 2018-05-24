package com.lysenkova.soapstore.dao.jdbc;

import com.lysenkova.soapstore.dao.ProductDao;
import com.lysenkova.soapstore.dao.mapper.ProductMapper;
import com.lysenkova.soapstore.entity.Product;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcProductDao implements ProductDao {
    private final static String GET_ALL_SQL = "select id, name, price, image, date from products";

    private final static ProductMapper PRODUCT_MAPPER = new ProductMapper();

    private DataSource dataSource ;

    @Override
    public List<Product> getAll() throws IOException {
        String propertiesUrl = "/db/database.properties";
        Properties properties = new Properties();
        properties.load(String.class.getResourceAsStream(propertiesUrl));
        JdbcProductDao productDao = new JdbcProductDao();
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(properties.getProperty("database.url"));
        dataSource.setUser(properties.getProperty("database.username"));
        dataSource.setPassword(properties.getProperty("database.password"));
        productDao.setDataSource(dataSource);
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_SQL)) {
            while (resultSet.next()) {
                Product product = PRODUCT_MAPPER.mapRow(resultSet);
                products.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException("SQL error during getting all products. ", e);
        }
        return products;
    }

    public void setDataSource(MysqlDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
