package com.vytrack.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static final Properties properties=new Properties();


    static {

     try (    FileInputStream file=new FileInputStream("configuration.properties" ) ){
           properties.load(file);
          }
         catch ( Exception e ){
              e.printStackTrace();
             System.out.println("failed to load properties file");
         }
    }

    public static String getProperty( String key ){
        return properties.getProperty(key);
    }

    public static void main( String[] args ) {
        System.out.println(ConfigurationReader.getProperty("url"));
    }


}
