package com.lysenkova.soapstore.web.servlet;

import com.lysenkova.soapstore.entity.Product;
import com.lysenkova.soapstore.service.ProductService;
import com.lysenkova.soapstore.web.templater.ThymeleafConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

public class AddProductServlet extends HttpServlet {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private ProductService productService;

    public AddProductServlet(ProductService productService) {
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Get request in AddProductServlet");
        response.setStatus(HttpServletResponse.SC_OK);
        WebContext context = new WebContext(request, response, request.getServletContext());
        ThymeleafConfig.process("add.html", context, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Post request in AddProductServlet");
        addProduct(request);
        response.sendRedirect("/products");
    }

    private void addProduct(HttpServletRequest request) {
        Product product = new Product();

        product.setName(request.getParameter("name"));
        String price = request.getParameter("price").replace(",", ".");
        product.setPrice(Double.parseDouble(price));
        product.setImgRef(request.getParameter("imgRef"));
        Timestamp timestamp = Timestamp.valueOf(request.getParameter("localDateTime"));
        product.setLocalDateTime(timestamp.toLocalDateTime());
        productService.add(product);
    }
}
