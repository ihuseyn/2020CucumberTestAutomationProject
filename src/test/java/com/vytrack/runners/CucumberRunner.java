package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)  // this is from jUnit 4

@CucumberOptions(
   features ="src/test/resources/features/activities",// {you can add many other sources-if you need }
        glue="com/vytrack/step_definitions",
        dryRun =false,
        //tags="@parametrized_test",
       // tags="@negative_login or @parametrized_test",
       tags="@calendar_events",
        publish=true
)

public class CucumberRunner {



}
