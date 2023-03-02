package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.CreateCalendarEventPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.ConfigurationReader;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;
import java.util.function.LongFunction;

public class CreateCalendarEventStepDefinitions {

    CreateCalendarEventPage createCalendarEventPage=new CreateCalendarEventPage();
    LoginPage loginPage=new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
      //  loginPage.login(ConfigurationReader.getProperty("storemanager.username="));
    }

    @Given("user clicks on create calendar event button")
    public void user_clicks_on_create_calendar_event_button() {
        BrowserUtils.wait(5);
        createCalendarEventPage.clickCreateCalendarEvent();

    }

    /**
      | Title | B20 Graduation Party |
      | Description | All B20 friends are invited for this party! |    */

    @When("user adds new calendar event information")
    public void user_adds_new_calendar_event_information(Map<String, String> data) {
        data.forEach( ( k,v )-> System.out.println("key: "+k+" "+",-> Value: "+v));
        String title=data.get("Title");
        String description=data.get("Description");

        createCalendarEventPage.enterTitle(title);
        createCalendarEventPage.enterDescription(description);
        BrowserUtils.wait(4);

    }


    @Then("user verifies that new calendar event is displayed:")
    public void user_verifies_that_new_calendar_event_is_displayed(Map<String, String> data) {
        BrowserUtils.wait(4);
        String title=data.get("Title");
        String description=data.get("Description");

        Assert.assertEquals("Title Didn't match",title,createCalendarEventPage.getDateFromGeneralInfo("Title"));
        Assert.assertEquals("Description Not matching",description,createCalendarEventPage.getDateFromGeneralInfo("Description"));

    }


}
