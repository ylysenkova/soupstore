package com.lysenkova.soapstore.dao.utils;

import com.lysenkova.ioc.applicationcontext.ApplicationContext;
import com.lysenkova.ioc.applicationcontext.BeanFactoryPostProcessor;
import com.lysenkova.ioc.entity.BeanDefinition;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DataBaseConnectionBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ApplicationContext beanFactory) {
        String propertiesUrl = "/db/database.properties";
        Properties properties = new Properties();
        try {
            properties.load(String.class.getResourceAsStream(propertiesUrl));
            List<BeanDefinition> beanDefinitions = beanFactory.getBeanDefinitions();
            for (BeanDefinition beanDefinition : beanDefinitions) {
                Map<String, String> dependency = new HashMap<>();
                if (beanDefinition.getBeanClassName().equals("com.mysql.cj.jdbc.MysqlDataSource")) {
                    dependency.put("url", properties.getProperty("database.url"));
                    dependency.put("user", properties.getProperty("database.username"));
                    dependency.put("password", properties.getProperty("database.password"));
                    beanDefinition.setDependencies(dependency);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read property file.", e);
        }
    }
}
