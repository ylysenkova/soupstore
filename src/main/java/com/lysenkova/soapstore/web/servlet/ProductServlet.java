package com.lysenkova.soapstore.web.servlet;

import com.lysenkova.soapstore.entity.Product;
import com.lysenkova.soapstore.service.ProductService;
import com.lysenkova.soapstore.service.impl.ProductServiceImpl;
import com.lysenkova.soapstore.web.templater.PageGenerator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> productMap = new HashMap<>();

        List<Product> products = productService.getAll();
        productMap.put("products", products);
        response.getWriter().println(PageGenerator.instance().getPage("products.ftl", productMap));
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
