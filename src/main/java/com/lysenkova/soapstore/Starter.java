package com.lysenkova.soapstore;

import com.lysenkova.ioc.context.ApplicationContext;
import com.lysenkova.ioc.context.ClassPathApplicationContext;
import com.lysenkova.soapstore.service.ProductService;
import com.lysenkova.soapstore.service.UserService;
import com.lysenkova.soapstore.web.security.LoginFilter;
import com.lysenkova.soapstore.web.servlet.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class Starter {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathApplicationContext("context.xml");
        ProductService productService = applicationContext.getBean(ProductService.class);
        UserService userService = applicationContext.getBean(UserService.class);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new LoginServlet(userService)), "/login");
        context.addServlet(new ServletHolder(new LogoutServlet()), "/logout");
        context.addServlet(new ServletHolder(new ProductServlet(productService)), "/products");
        context.addServlet(new ServletHolder(new AddProductServlet(productService)), "/product/add");
        context.addServlet(new ServletHolder(new AssetsServlet()), "/assets/*");
        context.addFilter(new FilterHolder(new LoginFilter()), "/*", EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST));


        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
    }
}
