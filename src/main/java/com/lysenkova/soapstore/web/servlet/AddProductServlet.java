package com.lysenkova.soapstore.web.servlet;

import com.lysenkova.soapstore.entity.Product;
import com.lysenkova.soapstore.service.ProductService;
import com.lysenkova.soapstore.web.templater.PageGenerator;
import com.lysenkova.soapstore.web.templater.ThymeleafConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class AddProductServlet extends HttpServlet {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private ProductService productService;

    public AddProductServlet(ProductService productService) {
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Get request in AddProductServlet");
        TemplateEngine templateEngine = ThymeleafConfig.templateEngine();
        WebContext context = new WebContext(request, response, request.getServletContext());
        templateEngine.process("add.html", context, response.getWriter());
        response.setStatus(HttpServletResponse.SC_OK);
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
        product.setPrice(Double.parseDouble(request.getParameter("price").replace(",", ".")));
        product.setImgRef(request.getParameter("imgRef"));
        Timestamp timestamp = Timestamp.valueOf(request.getParameter("localDateTime"));
        product.setLocalDateTime(timestamp.toLocalDateTime());
        productService.add(product);
    }

//    public void setProductService(ProductServiceImpl.java productService) {
//        this.productService = productService;
//    }
}
