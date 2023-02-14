package com.vytrack.pages.Notes;
public class Note1 {}/*

BDD - behavior driven development (in terms test automation, it's about writing test scenarios from end-user perspective)
TDD - Test Driven Development (writing unit tests first and then code itself/application code)
DDT - Data Driven Testing (pulling the test data outside of the code)
Test becomes data driven when test data is not hard-coded (no stored as variables)
If we use Cucumber BDD in our project we  call this framework BDD framework.
One of the most popular frameworks was Keyword Driven Framework (it's when test steps are defined in excel file, like click here, enter test here, assert this or that)
### How do you start automation?
 There is a story on Jira, and you need to test it.
 If development and testing happens within the same sprint, it means that feature that is going to be tested is not on the website until developer build it and deploy it to the test environment.
 Before new build is deployed to the test environment (with the feature that you need to test), you can create feature file, write scenarios and automate steps that are preceding that feature.
 1. Create feature file
 2. Write Scenarios
 3. Find elements for the pages that are gonna be involved into your scenarios (automate existing pages if needed)
 4. Store these elements into corresponding page classes
 5. Provide code implementation for the test steps (implement scenario phrases)
 6. Execute automation via CI server (we gonna talk about this in a Jenkins class. This step is not mandatory in every company)
 7. Generate a report
 8. Attach report to the Jira issue
 9. Open pull request to merge changes from your branch with a master branch. You shouldn't be able to approve pull request by yourself. It must be someone from your team (who can review your code as well).
How do we work with cucumber bdd?
feature file --> write scenarios --> performing dryRun --> implement step definitions --> run tests
The biggest benefit of Cucumber BDD is a re-usability of test steps. We don't need to re-implement already implemented steps. For instance, if we have a login step in 1 test scenario, it can be used in other scenarios regardless on where are they located (scenarios can be in a any feature file)
+ Cucumber helps to understand test scenarios to the non-technical people. Since test scenarios are written in the plain English, anyone can read them.
Components of cucumber BDD framework:
runner class ---> to run tests. In intellij, there is a way to run features directly without runner class.
what are the components of runner class?
@RunWith(Cucumber.class)
@CucumberOptions(
       features = "src/test/resources/features",
       glue = "com/vytrack/step_definitions",
       dryRun = false
)
public class CucumberRunner {
}
CucumberRunner - you can name this class in any name. Just don't call it Ayran.
Usually people call it TestRunner, CukesRunner, CucumberRunner.
Q: Can we have more than one runner class?
A: Yes, we can have as many as we need. In my project we had around 30 runner for parallel testing.
Q: Do we need anything inside a class?
A: No.
dryRun = false - to run tests
dryRun = true - to generate missing test definitions
We alway performing dryRun after adding new test scenarios.
Method that has a code implementation of the test step calls step definition. That's why, package that groups all step definition classes calls step_defintions.
glue - path to the package with step definitions. Can be single string or array.
features - path to the folder with a feature files. Can contain sub folder as well. Accepts single string or array.
step definitions - code implementation
feature files - test scenarios. Usually 1 test case = 1 test scenario. Test scenarios that have same steps but different test data can be replaced with Scenario Outline.
Q: What is object repository?
A: It's the place where you store locators. It can be page classes or properties files named after pages.
Break until 9:12
click and hold command (control for windows) and make a mouse/touch pad click on the method/class.
In order to run specific scenarios and ignore other scenarios we use tags in cucumber.
1. put the tag on top of scenario or feature file
2. put that tag in the runner class to run that specific scenario
 NOTE: if you want to exclude scenario with specific tag from execution, but nor part upfront.
 For example: tags = "not @parametrized_test"
 If you want to run scenario with 2 specific tags only use and
  For example: tags = "@parametrized_test and @driver"
 If you want to run scenarios with either or tags, use or keyword
  For example: tags = "@parametrized_test or @driver"




*/

