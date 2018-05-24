package com.lysenkova.soapstore.service.impl;

import com.lysenkova.ioc.applicationcontext.ApplicationContext;
import com.lysenkova.ioc.applicationcontext.ClassPathApplicationContext;
import com.lysenkova.soapstore.dao.ProductDao;
import com.lysenkova.soapstore.dao.jdbc.JdbcProductDao;
import com.lysenkova.soapstore.entity.Product;
import com.lysenkova.soapstore.service.ProductService;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private JdbcProductDao productDao;

    @Override
    public List<Product> getAll() {
        return getProductDao().getAll();
    }

    @Override
    public void add(Product product) {

    }

    public JdbcProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(JdbcProductDao productDao) {
        this.productDao = productDao;
    }
}
