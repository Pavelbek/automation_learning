package com.socks.api.utils;

import java.io.*;
import java.util.Properties;

public class ApiPropertiesReader {

    public static String getProperty(String propertyName){
        Properties properties = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream("./src/main/resources/api.properties");
            properties.load(in);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }
}
