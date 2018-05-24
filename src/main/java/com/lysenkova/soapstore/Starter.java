package com.lysenkova.soapstore;

import com.lysenkova.soapstore.dao.jdbc.JdbcProductDao;
import com.lysenkova.soapstore.web.servlet.LoginServlet;
import com.lysenkova.soapstore.web.servlet.ProductServlet;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.Properties;

public class Starter {
    public static void main(String[] args) throws Exception {




        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new LoginServlet()), "/login");
        context.addServlet(new ServletHolder(new ProductServlet()), "/products");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
    }
}
