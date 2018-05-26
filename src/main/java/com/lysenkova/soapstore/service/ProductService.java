package com.lysenkova.soapstore.service;

import com.lysenkova.soapstore.entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getAll();

    void add(Product product);
}
