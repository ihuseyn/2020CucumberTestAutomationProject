package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)  // this is from jUnit 4

@CucumberOptions(

        plugin= {   "rerun:target/rerun.txt",
                     "json:target/cucumber.json"
        },

      //  {you can add many other sources-if you need }
        features ={
                "src/test/resources/features/activities"
        },
        glue="com/vytrack/step_definitions",
        dryRun =false,
        //tags="@parametrized_test",
       // tags="@negative_login or @parametrized_test",
       tags="",
        publish=true

)

public class CucumberRunner {



}
