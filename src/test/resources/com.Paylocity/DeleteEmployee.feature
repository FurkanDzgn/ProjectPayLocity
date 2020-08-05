Feature: Paylocity delete employee
  Scenario: Validation of Employee Delete
    Given navigate To The Website
    When User enters valid User Name and password
    * I am on The Benefits Dashboard Page
    * Select delete button and delete employee details
    * validate employee deleted