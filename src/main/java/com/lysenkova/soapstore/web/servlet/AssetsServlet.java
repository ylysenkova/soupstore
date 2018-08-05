package com.lysenkova.soapstore.web.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class AssetsServlet extends HttpServlet {

    public AssetsServlet() {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        InputStream imageURL = getFilePath(request);
        if (imageURL != null) {
            try (BufferedInputStream inputStream = new BufferedInputStream(imageURL);
                 BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
                int value;
                while ((value = inputStream.read()) != -1) {
                    outputStream.write(value);
                }
                outputStream.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private InputStream getFilePath(HttpServletRequest request) {
        String path = request.getRequestURI().substring(1);
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream pathUrl = classLoader.getResourceAsStream(path);
        if (pathUrl == null) {
            throw new RuntimeException("Can not find path.");
        }
        return pathUrl;
    }
}
