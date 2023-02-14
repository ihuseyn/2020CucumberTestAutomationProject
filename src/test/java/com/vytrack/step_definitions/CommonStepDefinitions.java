package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import io.cucumber.java.en.Given;

public class CommonStepDefinitions {

    LoginPage loginPage=new LoginPage();

    @Given("user navigates to {string} and {string}")
    public void user_navigates_to_and(String string, String string2) {
       loginPage.navigateTo(string,string2);

    }

}
