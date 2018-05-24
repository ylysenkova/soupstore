package com.lysenkova.soapstore.dao.jdbc;

import com.lysenkova.soapstore.dao.ProductDao;
import com.lysenkova.soapstore.entity.Product;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;

public class JdbcProductDaoTest {
    private JdbcProductDao productDao = new JdbcProductDao();

    @Before
    public void injectDataSource() throws IOException {
        String propertiesUrl = "/db/database.properties";
        Properties properties = new Properties();
        properties.load(String.class.getResourceAsStream(propertiesUrl));
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(properties.getProperty("database.url"));
        dataSource.setUser(properties.getProperty("database.username"));
        dataSource.setPassword(properties.getProperty("database.password"));
        productDao.setDataSource(dataSource);
    }

    @Test
    public void getAll(){
        List<Product> products = productDao.getAll();
        for (Product product : products) {
            assertNotNull(product.getId());
            assertNotNull(product.getName());
            assertNotNull(product.getPrice());
            assertNotNull(product.getImgRef());
            assertNotNull(product.getLocalDateTime());
        }


    }

    @Test
    public void add()  {
        Product product = new Product();
        product.setName("Flower");
        product.setPrice(40.00);
        product.setImgRef("c:/image.jpg");
        int expected = productDao.getAll().size() + 1;
        productDao.add(product);
        int actual = productDao.getAll().size();
        assertEquals(expected, actual);
    }
}