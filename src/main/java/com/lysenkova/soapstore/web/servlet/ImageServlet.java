package com.lysenkova.soapstore.web.servlet;

import com.lysenkova.soapstore.service.ProductService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageServlet extends HttpServlet {
    private static final String RESOURCE_DIR = "src/main/resources";
    private ProductService productService;

    public ImageServlet(ProductService productService) {
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String imageURL = request.getRequestURI();
        if(imageURL!=null) {
            try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(RESOURCE_DIR + imageURL));
                BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
                int value;
                while ((value=inputStream.read())!=-1) {
                 outputStream.write(value);
                }
                outputStream.flush();
            }
        }
    }
}
