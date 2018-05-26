package com.lysenkova.soapstore.service.impl;

import com.lysenkova.soapstore.dao.ProductDao;
import com.lysenkova.soapstore.entity.Product;
import com.lysenkova.soapstore.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public void add(Product product) {
        productDao.add(product);
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
