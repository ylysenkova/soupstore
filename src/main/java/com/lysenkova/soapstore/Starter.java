package com.lysenkova.soapstore;

import com.lysenkova.ioc.applicationcontext.ApplicationContext;
import com.lysenkova.ioc.applicationcontext.ClassPathApplicationContext;
import com.lysenkova.soapstore.dao.jdbc.JdbcProductDao;
import com.lysenkova.soapstore.dao.jdbc.JdbcUserDao;
import com.lysenkova.soapstore.service.ProductService;
import com.lysenkova.soapstore.service.impl.ProductServiceImpl;
import com.lysenkova.soapstore.web.servlet.AddProductServlet;
import com.lysenkova.soapstore.web.servlet.LoginServlet;
import com.lysenkova.soapstore.web.servlet.ProductServlet;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.time.LocalDateTime;
import java.util.Properties;

public class Starter {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathApplicationContext("src\\main\\resources\\context.xml");
        JdbcProductDao productDao = applicationContext.getBean(JdbcProductDao.class);
        JdbcUserDao userDao = applicationContext.getBean(JdbcUserDao.class);
        ProductServiceImpl productService = applicationContext.getBean(ProductServiceImpl.class);
        LoginServlet loginServlet = applicationContext.getBean(LoginServlet.class);
        ProductServlet productServlet = applicationContext.getBean(ProductServlet.class);
        AddProductServlet addProductServlet = applicationContext.getBean(AddProductServlet.class);

        String propertiesUrl = "/db/database.properties";
        Properties properties = new Properties();
        properties.load(String.class.getResourceAsStream(propertiesUrl));
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(properties.getProperty("database.url"));
        dataSource.setUser(properties.getProperty("database.username"));
        dataSource.setPassword(properties.getProperty("database.password"));
        productDao.setDataSource(dataSource);
        productService.setProductDao(productDao);
        userDao.setDataSource(dataSource);



        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(loginServlet), "/login");
        context.addServlet(new ServletHolder(productServlet), "/products");
        context.addServlet(new ServletHolder(addProductServlet), "/product/add");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
    }
}
