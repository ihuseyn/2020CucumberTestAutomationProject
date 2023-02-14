
@login
Feature: As user, I want to be able to
         login under different roles

    # this will be executed before scenario in particular feature file
    # scenario pre-candition
  Background: common steps
       Given user is on the landing

    Scenario: Login as a sales manager

       When  user logs in
       Then user should see dashboard page

   @parametrized_test  @smoke_test
   Scenario: Parametrized login
    # Given user is on the landing  ( since it keeps repeating took to background)
       When user logs in as a "sales manager"
       Then user should see dashboard page
     # "driver"->is parameter."" allows to do test parametrization

   @negative_login          #  @firefox ( if u want to switch auto driver )
   Scenario: Invalid password
   # Given user is on the landing
      When user logs in with "storemanager85" username and "wrong" password
      Then user verifies that "Invalid user name or password." message is displayed







