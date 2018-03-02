package com.proiect.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public enum ConfigHelper {
    INSTANCE;
    private static Properties properties = null;

    public String getProperty(String property) {
        properties = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }

}
