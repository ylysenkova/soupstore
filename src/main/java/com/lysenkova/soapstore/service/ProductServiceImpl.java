package com.lysenkova.soapstore.service;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new JdbcProductDao();
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }
}
