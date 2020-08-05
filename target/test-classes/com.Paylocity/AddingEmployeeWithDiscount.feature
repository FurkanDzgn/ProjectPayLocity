Feature:Paylocity Employee adding discount test
  Scenario: Add Employee with discount
    Given navigate to the Website
    When User enters valid user name, password and click login
    Then validate title
    * add employee
    * enter Employee details
    * First Name does begin "A" or "a"
    * click save
    * Validate Employee in the table
    * the employee has a 10% discount
