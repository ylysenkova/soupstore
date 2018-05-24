package com.lysenkova.soapstore.service.impl;

import com.lysenkova.soapstore.dao.ProductDao;
import com.lysenkova.soapstore.dao.jdbc.JdbcProductDao;
import com.lysenkova.soapstore.entity.Product;
import com.lysenkova.soapstore.service.ProductService;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new JdbcProductDao();
    @Override
    public List<Product> getAll() throws IOException {
        return productDao.getAll();
    }
}
