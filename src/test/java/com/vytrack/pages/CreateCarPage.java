package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCarPage extends BasePage {

    @FindBy(css = "[title='Create Car']")
    private WebElement createCarBtn;

    @FindBy(name = "custom_entity_type[LicensePlate]")
    private WebElement licansePlateInputBox;

    @FindBy(name = "custom_entity_type[ModelYear]")
    private WebElement modelYearInputBox;

    public void clickonCreateCar(){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.elementToBeClickable(createCarBtn)).click();
        BrowserUtils.wait(6);
        System.out.println("Clicking on 'Create Car' button");
    }

    public void enterLicensePlate(String licensePlate){
        BrowserUtils.enterTxt(licansePlateInputBox,licensePlate);
        BrowserUtils.wait(2);

   /* WebDriverWait wait =new WebDriverWait(Driver.getDriver(),20);
      wait.until(ExpectedConditions.visibilityOf(licansePlateInputBox));
      licansePlateInputBox.clear();
      licansePlateInputBox.sendKeys(licensePlate);   */
    }

    public void enterModelYear(String modelYear){
       BrowserUtils.enterTxt(modelYearInputBox,modelYear);
        BrowserUtils.wait(2);
    }


}
