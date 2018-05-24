package com.lysenkova.soapstore.web.servlet;

import com.lysenkova.ioc.applicationcontext.ApplicationContext;
import com.lysenkova.ioc.applicationcontext.ClassPathApplicationContext;
import com.lysenkova.soapstore.entity.Product;
import com.lysenkova.soapstore.service.ProductService;
import com.lysenkova.soapstore.service.impl.ProductServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

public class AddProductServlet extends HttpServlet {
    private ProductServiceImpl productService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addProduct(request);
        response.sendRedirect("/products");
    }

    private void addProduct(HttpServletRequest request) {
        Product product = new Product();

        product.setName(request.getParameter("name"));
        product.setPrice(Double.parseDouble(request.getParameter("price").replace(",", ".")));
        product.setImgRef(request.getParameter("imgRef"));
        Timestamp timestamp = Timestamp.valueOf(request.getParameter("localDateTime"));
        product.setLocalDateTime(timestamp.toLocalDateTime());
        getProductService().add(product);
    }

    public ProductServiceImpl getProductService() {
        return productService;
    }

    public void setProductService(ProductServiceImpl productService) {
        this.productService = productService;
    }
}
