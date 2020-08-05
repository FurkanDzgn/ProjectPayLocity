package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class EditEmployee {

    WebDriver driver= Driver.getDriver("chrome");
    LoginPage loginPage=new LoginPage(driver);
    HomePage homePage=new HomePage(driver);

    @Given("navigate to The Website")
    public void navigate_to_The_Website() {
        driver.get(ConfigReader.getProperty("url"));
    }

    @When("User enters valid user Name and password")
    public void user_enters_valid_user_Name_and_password() {
        loginPage.userName.sendKeys(ConfigReader.getProperty("username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("password"));
        loginPage.loginButton.click();
    }

    @When("I am on the Benefits Dashboard Page")
    public void i_am_on_the_Benefits_Dashboard_Page() {
        Assert.assertEquals("Benefits Dashboard",driver.getTitle());
    }

    @When("Select action edit and edit employee details")
    public void select_action_edit_and_edit_employee_details() {
        homePage.editButton.click();
        homePage.firstName.clear();
        homePage.firstName.sendKeys(ConfigReader.getProperty("fName"));
        homePage.lastName.clear();
        homePage.lastName.sendKeys(ConfigReader.getProperty("lName"));
        homePage.dependent.clear();
        homePage.dependent.sendKeys(ConfigReader.getProperty("dependent"));
        homePage.submitButton.click();

    }

    @When("validate employee changed")
    public void validate_employee_changed() {
        Assert.assertEquals("Frank",homePage.nameCase3.getText());
        Assert.assertEquals("Chap",homePage.lastNameCase3.getText());

    }
}
