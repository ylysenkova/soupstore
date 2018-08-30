package com.lysenkova.soapstore.dao.jdbc.itest;

import com.lysenkova.soapstore.dao.jdbc.JdbcProductDao;
import com.lysenkova.soapstore.entity.Product;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class JdbcProductDaoITest {
    private JdbcProductDao productDao = new JdbcProductDao();

        @Before
        public void before() throws IOException {
            ConfigurationDataBase config = new ConfigurationDataBase();
            productDao.setDataSource(config.getDataSource());
        }

    @Test
    public void getAll(){
        List<Product> products = productDao.getAll();
        for (Product product : products) {
            assertNotNull(product.getName());
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