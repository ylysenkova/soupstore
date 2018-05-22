package com.lysenkova.soapstore;

import com.lysenkova.soapstore.web.servlet.LoginServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.Properties;

public class Starter {
    public static void main(String[] args) throws Exception {
        String propertiesUrl = "/db/database.properties";
        Properties properties = new Properties();
        properties.load(String.class.getResourceAsStream(propertiesUrl));

        properties.getProperty("database.url");
        properties.getProperty("database.username");
        properties.getProperty("database.password");

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new LoginServlet()), "/login");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
    }
}
