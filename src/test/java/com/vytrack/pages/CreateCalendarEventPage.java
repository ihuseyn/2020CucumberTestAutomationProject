package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class CreateCalendarEventPage extends BasePage{

   @FindBy(css = "[title='Create Calendar event']")
    private WebElement crateCalendarEventButton;

   @FindBy(name = "oro_calendar_event_form[title]")
    private WebElement titleInputBox;

   @FindBy(id = "tinymce")
    private WebElement descriptionInputBox;

   public void clickCreateCalendarEvent(){
       BrowserUtils.clickOnElement(crateCalendarEventButton);
   }


   public void enterTitle(String txt){
       BrowserUtils.enterTxt(titleInputBox,txt);

   }
   public void enterDescription(String txt){
       WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
       // defaultContent() exits all frames

       Driver.getDriver().switchTo().defaultContent();
       // wait frame and switch to it
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
       //enter txt
       descriptionInputBox.sendKeys(txt);
  //  BrowserUtils.enterTxt(descriptionInputBox,txt);
       // exit from the frame
       Driver.getDriver().switchTo().defaultContent();

   }

   public String getDateFromGeneralInfo(String parameterName ){
       WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
       String xpath="//label[text()='"+parameterName+"']/../div/div";
       WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
       return element.getText().trim();
   }

}
