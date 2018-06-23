package com.lysenkova.soapstore.web.servlet;

import com.google.common.hash.Hashing;
import com.lysenkova.soapstore.entity.User;
import com.lysenkova.soapstore.service.UserService;
import com.lysenkova.soapstore.web.security.PasswordGenerator;
import com.lysenkova.soapstore.web.templater.ThymeleafConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class LoginServlet extends HttpServlet {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserService userService;

    public LoginServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Get request in LoginServlet");
        removeToken(request, response);
        TemplateEngine templateEngine = ThymeleafConfig.templateEngine();
        WebContext context = new WebContext(request, response, request.getServletContext(), request.getLocale());
        templateEngine.process("login.html", context, response.getWriter());
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Post request in LoginServlet");
        sendTokenToCookie(request, response);
        response.sendRedirect("/products");
    }

    private void sendTokenToCookie(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        LOGGER.info("Checking if User with login {} authorized", login);
        Optional<String> token = getToken(login, password);
        if (token.isPresent()) {
            Cookie cookie = new Cookie("user-token", token.get());
            cookie.setMaxAge(1800);
            response.addCookie(cookie);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
//        return response;
    }

    private Optional<String> getToken(String login, String password) {
        LOGGER.info("User with login {} trying to log in", login);
        User user = userService.getByLogin(login);
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String hashedPassword = passwordGenerator.hashPassword(password);
        if (login.equals(user.getLogin()) && hashedPassword.equals(user.getPassword())) {
            LOGGER.info("User {} has logged in.", user.getLogin());
            String token = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
            return Optional.of(token);
        }
        return Optional.empty();
    }

    private void removeToken(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user-token".equals(cookie.getName())) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }

}
