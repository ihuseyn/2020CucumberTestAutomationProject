package com.vytrack.step_definitions;

import com.vytrack.pages.CreatCarPage;
import com.vytrack.utils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class CreateCarStepDefinitions {

    CreatCarPage creatCarPage=new CreatCarPage();

    @Given("user click on create car button")
    public void user_click_on_create_car_button() {
        BrowserUtils.wait(3);
     creatCarPage.clickonCreateCar();

    }
/*
    | License Plate |  SDET  |
    | Model Year    |  2021  |
       key             value
        Map it's data structure where every value is references by key
        datatable { license plate = SDET
                    Model year = 2021 }
     Map --> it has to be exactly 2 columns
     List--> 1 column then it can be just a List
     List<Maps> --> more than 2 column

 */
    @When("user adds new vehicle information")
    public void user_adds_new_vehicle_information(Map<String, String> dataTable) {
        // to get all key and value one by one
         dataTable.forEach( (k,v) ->System.out.println("Key: "+k+", Value: "+v) );  // Lambda
     /*   for (Map.Entry<String, String> entry:dataTable.entrySet()){
            System.out.println("key:"+entry.getKey()+ " Value: "+entry.getValue());
        }    */

        System.out.println("License plate:"+dataTable.get("License Plate"));
        System.out.println("Model year:"+dataTable.get("Model Year"));

        creatCarPage.enterLicenPlate( dataTable.get("License plate") );

        creatCarPage.enterModelYear( dataTable.get("Model Year") );



    }

}
