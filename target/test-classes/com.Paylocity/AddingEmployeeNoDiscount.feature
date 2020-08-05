Feature: Paylocity Employee adding test

  Scenario: Validation of Employee adding no discount
    Given navigate to the website
    When User enters valid user name and password
    * I am on the Benefits Dashboard page
    * I select Add Employee
    * I should be able able to enter employee details
    * First Name does bot begin "A" or "a"
    * the employee should save
    * I should see the employee in the table
    * the benefit cost calculations are correct

