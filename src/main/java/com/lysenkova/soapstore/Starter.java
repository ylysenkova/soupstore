package com.lysenkova.soapstore;

import com.lysenkova.ioc.applicationcontext.ApplicationContext;
import com.lysenkova.ioc.applicationcontext.ClassPathApplicationContext;
import com.lysenkova.soapstore.service.ProductService;
import com.lysenkova.soapstore.service.SecurityService;
import com.lysenkova.soapstore.service.UserService;
import com.lysenkova.soapstore.service.impl.ProductServiceImpl;
import com.lysenkova.soapstore.service.impl.SecurityServiceImpl;
import com.lysenkova.soapstore.service.impl.UserServiceImpl;
import com.lysenkova.soapstore.web.security.LoginFilter;
import com.lysenkova.soapstore.web.servlet.AddProductServlet;
import com.lysenkova.soapstore.web.servlet.ImageServlet;
import com.lysenkova.soapstore.web.servlet.LoginServlet;
import com.lysenkova.soapstore.web.servlet.ProductServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class Starter {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathApplicationContext("context.xml");
//        ProductDao productDao = applicationContext.getBean(JdbcProductDao.class);
//        UserDao userDao = applicationContext.getBean(JdbcUserDao.class);
        ProductService productService = applicationContext.getBean(ProductServiceImpl.class);
        UserService userService = applicationContext.getBean(UserServiceImpl.class);
        SecurityService securityService = applicationContext.getBean(SecurityServiceImpl.class);

//        String propertiesUrl = "/db/database.properties";
//        Properties properties = new Properties();
//        properties.load(String.class.getResourceAsStream(propertiesUrl));
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setURL(properties.getProperty("database.url"));
//        dataSource.setUser(properties.getProperty("database.username"));
//        dataSource.setPassword(properties.getProperty("database.password"));
//        productDao.setDataSource(dataSource);
//        userDao.setDataSource(dataSource);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new LoginServlet(securityService)), "/login");
        context.addServlet(new ServletHolder(new ProductServlet(productService)), "/products");
        context.addServlet(new ServletHolder(new AddProductServlet(productService)), "/product/add");
        context.addServlet(new ServletHolder(new ImageServlet(productService)), "/assets/image/*");
        context.addFilter(new FilterHolder(new LoginFilter(userService)), "/*", EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST));


        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
    }
}
