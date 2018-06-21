package com.lysenkova.soapstore.web.templater;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

public class ThymeleafConfig {

    public static TemplateEngine templateEngine(ServletContext servletContext) {
        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(templateResolver(servletContext));
        return engine;
    }

    private static ITemplateResolver templateResolver(ServletContext servletContext) {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(servletContext);
        resolver.setPrefix("/src/main/resources/assets/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        return resolver;
    }

}