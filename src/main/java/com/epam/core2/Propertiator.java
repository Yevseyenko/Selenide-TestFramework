package com.epam.core2;

import ch.qos.logback.classic.Logger;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.LoggerFactory;

public class Propertiator {
    Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(this.getClass());
    private static final String path = System.getProperty("user.dir") + "/src/main/resources/application.properties";

    private static String getPropertie(String name) {
        PropertiesConfiguration properties = null;
        try {
            properties = new PropertiesConfiguration(path);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return properties.getProperty(name).toString();
    }

    public static String getTokenDomain() {
        return getPropertie("token");
    }
}
