package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "btn main-group btn-primary pull-right ")
    private WebElement CreateCalendarEvent;

    @FindBy(xpath = "//button[contains(text(),'Save and Close')][1]")
    protected WebElement saveAndCloseButton;

    @FindBy(css = "[class='loader-mask']")
    protected List<WebElement> loaderMask;


    @FindBy( className= "oro-subtitle")
    protected WebElement pageSubTitle;

    public String getPageSubTitle(){
        return pageSubTitle.getText();
    }

   /**  @param tab--> fleet dashboard sales activiteis
        @param module--> vehicles odometer, costs etc      */

    public void navigateTo(String tab,String module){
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),30);
        String tabXpath="//*[contains(text(),'"+tab+"') and @class='title title-level-1']";
        WebElement tabElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tabXpath)));

        // wait until loader mask disappears
        wait.until(ExpectedConditions.invisibilityOfAllElements(loaderMask));
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();

        String moduleXpath="//*[contains(text(),'"+module+"') and @class='title title-level-2']";
        WebElement moduleElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(moduleElement)).click();
        // wait until loader mask disappears

        wait.until(ExpectedConditions.invisibilityOfAllElements(loaderMask));
        BrowserUtils.wait(3);

    }

    public void clickAndClose(){
        BrowserUtils.clickOnElement(saveAndCloseButton);
    }

}
