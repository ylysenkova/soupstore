package com.lysenkova.soapstore.web.servlet;

import com.lysenkova.soapstore.service.ProductService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class AssetsServlet extends HttpServlet {

    public AssetsServlet(ProductService productService) {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String imageURL = getFilePath(request);
        if (imageURL != null) {
            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(imageURL));
                 BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
                int value;
                while ((value = inputStream.read()) != -1) {
                    outputStream.write(value);
                }
                outputStream.flush();
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private String getFilePath(HttpServletRequest request) {
        String path = request.getRequestURI().substring(1);
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getPath());
        path = file.getAbsolutePath();
        return path;
    }
}
