package com.lysenkova.soapstore.dao;

import com.lysenkova.soapstore.entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductDao {
    List<Product> getAll() throws IOException;
}
