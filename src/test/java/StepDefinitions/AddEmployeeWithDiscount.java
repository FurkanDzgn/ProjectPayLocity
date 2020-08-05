package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddEmployeeWithDiscount {

    WebDriver driver= Driver.getDriver("chrome");
    LoginPage loginPage=new LoginPage(driver);
    HomePage homePage=new HomePage(driver);


    @Given("navigate to the Website")
    public void navigate_to_the_Website() {
     driver.get(ConfigReader.getProperty("url"));
    }

    @When("User enters valid user name, password and click login")
    public void user_enters_valid_user_name_password_and_click_login() {
       loginPage.userName.sendKeys(ConfigReader.getProperty("username"));
       loginPage.password.sendKeys(ConfigReader.getProperty("password"));
       loginPage.loginButton.click();
    }

    @Then("validate title")
    public void validate_title() {
        Assert.assertEquals("Benefits Dashboard",driver.getTitle());
    }

    @Then("add employee")
    public void add_employee() {
       homePage.addEmp.click();
    }

    @Then("enter Employee details")
    public void enter_Employee_details() {
        homePage.firstName.sendKeys(ConfigReader.getProperty("firstName"));
        homePage.lastName.sendKeys(ConfigReader.getProperty("lastName"));
        homePage.dependent.sendKeys(ConfigReader.getProperty("dependent"));
    }

    @Then("First Name does begin {string} or {string}")
    public void first_Name_does_begin_or(String string, String string2) {
        String actualName=ConfigReader.getProperty("firstName");
        Assert.assertTrue(actualName.startsWith("A")&&!actualName.startsWith("a"));
    }

    @Then("click save")
    public void click_save() {
        homePage.submitButton.click();
    }

    @Then("Validate Employee in the table")
    public void validate_Employee_in_the_table() {

      Assert.assertEquals("Archel",homePage.nameCase2.getText());
      Assert.assertEquals("lee",homePage.lastNameCase2.getText());

    }

    @Then("the employee has a {int}% discount")
    public void the_employee_has_a_discount(Integer int1) {
        double expCost=(double)1000/(double)26 - ((double)1000/(double)26)*((double)10/(double)100)+0.01;
        String str=""+expCost;
        double expected=Double.parseDouble(str.substring(0,str.indexOf('.')+3));
        double actual=Double.parseDouble(homePage.benefitsCase2.getText());
        System.out.println(expected);
        System.out.println(actual);
        Assert.assertTrue(expected==actual);

    }


}
