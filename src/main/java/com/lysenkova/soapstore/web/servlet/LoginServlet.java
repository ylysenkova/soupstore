package com.lysenkova.soapstore.web.servlet;

import com.lysenkova.soapstore.service.SecurityService;
import com.lysenkova.soapstore.web.templater.PageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LoginServlet extends HttpServlet {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private SecurityService securityService;

    public LoginServlet(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Get request in LoginServlet");
        Map<String, Object> pageGeneratorMap = new HashMap<>();
        response.getWriter().println(PageGenerator.instance().getPage("login.ftl", pageGeneratorMap));
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Post request in LoginServlet");
        sendUuidToCookie(request, response);
        response.sendRedirect("/products");
    }

    private HttpServletResponse sendUuidToCookie(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Map<String, String> loginPasswordMap = new HashMap<>();
        loginPasswordMap.put(login, password);
        LOGGER.info("Checking if User with login {} authorized", login);
        UUID uuid = securityService.validateUser(loginPasswordMap);
        if (uuid != null) {
            String userToken = uuid.toString();
            Cookie cookie = new Cookie("user-token", userToken);
            cookie.setMaxAge(1800);
            response.addCookie(cookie);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        return response;
    }

}
