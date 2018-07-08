package com.lysenkova.soapstore.util;

import com.lysenkova.ioc.applicationcontext.BeanFactoryPostProcessor;
import com.lysenkova.ioc.entity.BeanDefinition;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertiesBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(List<BeanDefinition> beanDefinitions) {
        String propertiesUrl = "/db/database.properties";
        Properties properties = new Properties();
        try {
            properties.load(String.class.getResourceAsStream(propertiesUrl));
            for (BeanDefinition beanDefinition : beanDefinitions) {
                Map<String, String> dependency = new HashMap<>();
                for (Map.Entry<String, String> beanDefinitionDependency : beanDefinition.getDependencies().entrySet()) {
                    if(beanDefinitionDependency.getValue().startsWith("$")) {
                        String propertyValue = beanDefinitionDependency.getValue()
                                .substring(2, beanDefinitionDependency.getValue().length()-1);
                        dependency.put(beanDefinitionDependency.getKey(), properties.getProperty(propertyValue));
                        beanDefinition.setDependencies(dependency);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read property file.", e);
        }
    }

}
