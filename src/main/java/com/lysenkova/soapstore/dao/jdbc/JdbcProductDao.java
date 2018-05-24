package com.lysenkova.soapstore.dao.jdbc;

import com.lysenkova.soapstore.dao.ProductDao;
import com.lysenkova.soapstore.dao.mapper.ProductMapper;
import com.lysenkova.soapstore.entity.Product;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {
    private final static String GET_ALL_SQL = "select id, name, price, image, date from products";

    private final static ProductMapper PRODUCT_MAPPER = new ProductMapper();

    private DataSource dataSource;

    @Override
    public List<Product> getAll() {
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
