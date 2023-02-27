package com.vytrack.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Driver {

    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){

        if(driver==null){
            String browser=ConfigurationReader.getProperty("browser");
            switch (browser){
                case"chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case"edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                case"remote-chrome":
                    try{
                 // ChromeOptions chromeOptions=new ChromeOptions();
                    DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
                    desiredCapabilities.setBrowserName("chrome");
                    URL gridUrl=new URL("http://44.213.131.55:4444/wd/hub");
                    driver=new RemoteWebDriver( gridUrl, desiredCapabilities  );
                    } catch(Exception e){
                       e.printStackTrace();
                    }
                    break;
                default:
                    throw new RuntimeException(" no such browser yet! ");
            }
        }
         return driver;
    }
 /*   public static WebDriver getDriver( String browser ){

        if(driver==null){

            switch (browser){
                case"chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case"edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                default:
                    throw new RuntimeException(" no such browser yet! ");
            }
        }
        return driver;
    }    */
    public static void closeDriver(){
        if (driver !=null){
            driver.quit();
            driver=null;
        }
    }

}
