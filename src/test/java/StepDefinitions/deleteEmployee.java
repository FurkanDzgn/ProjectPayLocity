package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class deleteEmployee {

    WebDriver driver= Driver.getDriver("chrome");
    HomePage homePage=new HomePage(driver);
    LoginPage loginPage=new LoginPage(driver);

    @Given("navigate To The Website")
    public void navigate_To_The_Website() {
        driver.get(ConfigReader.getProperty("url"));
    }

    @When("User enters valid User Name and password")
    public void user_enters_valid_User_Name_and_password() {
        loginPage.userName.sendKeys(ConfigReader.getProperty("username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("password"));
        loginPage.loginButton.click();
    }

    @When("I am on The Benefits Dashboard Page")
    public void i_am_on_The_Benefits_Dashboard_Page() {
        Assert.assertEquals("Benefits Dashboard",driver.getTitle());
    }

    @When("Select delete button and delete employee details")
    public void select_delete_button_and_delete_employee_details() {
       homePage.deleteButton.click();
    }

    @When("validate employee deleted")
    public void validate_employee_deleted() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
