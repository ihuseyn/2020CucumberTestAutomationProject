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
    # Given user is on the landing  ( since it keeps repeating, moved Given to Background: )
    When user logs in as a "sales manager"
    Then user should see dashboard page
     # "driver"->is parameter."" allows to do test parametrization

  @parametrized_test  @smoke_test
  Scenario: Parametrized login
    When user logs in as a "store manager"
    Then user should see dashboard page

  @s_o
  Scenario Outline:  Parametrized login <role>
    When user logs in as a "<role>"
    Then user should see dashboard page

    Examples:               #auto format control+alt+l
      | role          |
      | sales manager |
      | store manager |


  @with_two_columns
  Scenario Outline:  Parametrized login <role>
    When user logs in as a "<role>"
    Then user should see "<page_title>" page

    Examples: roles & pageTitle
      | role          | page_title |
      | sales manager | Dashboard  |
      | store manager | Dashboard  |
      | driver        | Dashboard  |


  @negative_login          #  @firefox ( if u want to switch auto driver )
  Scenario: Invalid password
    # Given user is on the landing
    When user logs in with "storemanager85" username and "wrong" password
    Then user verifies that "Invalid user name or password." message is displayed

  @negative_scenario_output
  Scenario Outline: Invalid password <username> <password>
    When user logs in with "<username>" username and "<password>" password
    Then user verifies that "<message>" message is displayed

    Examples: data set
      | username | password | message                        |
      | wrong213 | bad      | Invalid user name or password. |
      | wrong32  | bad      | Invalid user name or password. |
      | wrong12  | bad      | Invalid user name or password. |












