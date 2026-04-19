package com.jdbctest.config;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    private static final Properties props = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("application.properties");
            props.load(fis);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
