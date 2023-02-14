package com.vytrack.step_definitions;

import com.vytrack.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before (order = 0)
    public void setup( Scenario scenario ){
       /* scenario.getSourceTagNames().forEach ( tag-> {

                if( tag.contains("firefox") ) {
                    Driver.getDriver("firefox" );
                }} );   */
        System.out.println( scenario.getSourceTagNames() );
        System.out.println("Starting Automation");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Before ("@db")  // this hook will run before scenarios with a tag @db
    public void dbSetup(){
        System.out.println("::Connecting Database::");
    }

    @After("@db")  // close after
    public void dbTeardown(){
        System.out.println("::Disconnecting from the Database::");
    }

    @After  // comes from cucumber
    public void teardown(){
        Driver.closeDriver();
        System.out.println("End of the execution");
    }

}
