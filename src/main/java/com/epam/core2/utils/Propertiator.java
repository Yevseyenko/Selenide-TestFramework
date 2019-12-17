package com.epam.core2.utils;

import ch.qos.logback.classic.Logger;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.LoggerFactory;

public class Propertiator {
    private static Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Propertiator.class);
    private static final String path = System.getProperty("user.dir") + "/src/main/resources/application.properties";

    private static String getProperty(String name) {
        PropertiesConfiguration properties = null;
        try {
            properties = new PropertiesConfiguration(path);
        } catch (ConfigurationException e) {
            e.printStackTrace();
            logger.error("Can't get property: " + name);
        }
        return properties.getProperty(name).toString();
    }


    public static String getTokenDomain() {
        return getProperty("token");
    }
}
