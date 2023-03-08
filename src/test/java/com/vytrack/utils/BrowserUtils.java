package com.vytrack.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.util.Date;

public class BrowserUtils {


    private static WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);

    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clickOnElement (WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void clickWithJS (WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js=( (JavascriptExecutor)(Driver.getDriver()) );
        js.executeScript("arguments[0].click",element);
    }

    public static void enterTxt(WebElement element, String txt){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(txt);
        // waits until whole text entered  like [java is great]-->[java is g] half way then use following wait
        wait.until(ExpectedConditions.attributeToBe(element,"value",txt));
        System.out.println("Entering txt: "+txt);
    }


    /*
     public static void takeScreenShot (String name){
        Date date=new Date();
        String path=System.getProperty("user.dir")+"/screenshots";
        TakesScreenshot takesScreenshot=( TakesScreenshot ) Driver.getDriver();
        byte[] data=takesScreenshot.getScreenshotAs(OutputType.BYTES);
        try (FileOutputStream outputStream=new FileOutputStream()){
        }
    }
     */ //screenshot halfway writtencode

}
