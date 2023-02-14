package com.vytrack.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
