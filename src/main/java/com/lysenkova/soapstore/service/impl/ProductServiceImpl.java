package com.lysenkova.soapstore.service.impl;

import com.lysenkova.soapstore.dao.jdbc.JdbcProductDao;
import com.lysenkova.soapstore.entity.Product;
import com.lysenkova.soapstore.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private JdbcProductDao productDao;

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public void add(Product product) {
        productDao.add(product);
    }

    public void setProductDao(JdbcProductDao productDao) {
        this.productDao = productDao;
    }
}
