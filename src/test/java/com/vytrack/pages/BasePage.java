package com.vytrack.pages;

import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy( className= "oro-subtitle")
    protected WebElement pageSubTitle;

    public String getPageSubTitle(){
        return pageSubTitle.getText();
    }

   /*  tab--> fleet dashboard sales activiteis
       module--> vehicles odometer, costs etc   */
    public void navigateTo(String tab,String module){

        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),30);
        String tabXpath=" //*[contains(text(),'"+tab+"') and @class='title title-level-1'] ";
        WebElement tabElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tabXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();

        String moduleXpath="//*[contains(text(),'"+module+"') and @class='title title-level-2']";
        WebElement moduleElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(moduleElement)).click();








    }

}
