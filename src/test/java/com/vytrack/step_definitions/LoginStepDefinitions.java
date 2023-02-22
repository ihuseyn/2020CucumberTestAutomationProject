package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage=new LoginPage();

    @Given("user is on the landing")
    public void user_is_on_the_landing() {
        Driver.getDriver().get("http://qa2.vytrack.com");
    }
    @When("user logs in")
    public void user_logs_in() throws InterruptedException {
        loginPage.login();
        BrowserUtils.wait(3);
    }
    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() {
        String expected="Dashboard";
        String actual= loginPage.getPageSubTitle().trim();
        Assert.assertEquals("title is not correct!",expected,actual);
        System.out.println("I see Dashboard page");
        Driver.closeDriver();
    }

    @Then("user should see {string} page")
    public void user_should_see_page(String string) {
        String actual= loginPage.getPageSubTitle().trim();
        BrowserUtils.wait(3);
        Assert.assertEquals("page title is not correct", string,actual);

    }


    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {
        loginPage.login(string);
        BrowserUtils.wait(3);
    }

    // String string="storemanager85"
    // String string2="wrong"
    // user logs in with "storemanager85" username and "wrong" password
    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
       loginPage.login(string,string2);
    }

    //user verifies that "Invalid user name or password." message is displayed
    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String expected) {
        String actual=loginPage.getWarningMessageText();
        BrowserUtils.wait(3);
        Assert.assertEquals("Title doesn't match", expected,actual);

    }

}
