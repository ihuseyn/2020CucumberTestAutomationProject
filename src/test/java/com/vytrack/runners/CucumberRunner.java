package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)  // this is from jUnit 4

@CucumberOptions(

        plugin= {   "rerun:target/rerun.txt",
                     "json:target/cucumber.json"

        },

        features ="src/test/resources/features",// {you can add many other sources-if you need }
        glue="com/vytrack/step_definitions",
        dryRun =false,
        //tags="@parametrized_test",
       // tags="@negative_login or @parametrized_test",
       tags="@smoke",
        publish=true

)

public class CucumberRunner {



}
