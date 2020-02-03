package com.anz.dataloader;

import com.anz.constants.CommonConstants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties loadProperties(String name) throws IOException {
        String configPath   =   Thread.currentThread().getContextClassLoader().getResource(name).getPath();
        Properties properties = new Properties();
        properties.load(new FileInputStream(configPath));
        return properties;
    }
}
