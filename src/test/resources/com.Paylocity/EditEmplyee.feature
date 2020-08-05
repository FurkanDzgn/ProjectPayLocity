Feature: Paylocity edit employee
  Scenario: Validation of Employee edit
    Given navigate to The Website
    When User enters valid user Name and password
    * I am on the Benefits Dashboard Page
    * Select action edit and edit employee details
    * validate employee changed