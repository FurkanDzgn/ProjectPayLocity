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

public class AddEmployeeStepsDef {

    WebDriver driver= Driver.getDriver("chrome");
    LoginPage page;
    HomePage homePage;

    @Given("navigate to the website")
    public void navigate_to_the_website() {
        page=new LoginPage(driver);
    //      driver.get("file:///C:/Users/12242/Desktop/login.html");
        homePage=new HomePage(driver);
        driver.get(ConfigReader.getProperty("url"));
    }

    @When("User enters valid user name and password")
    public void user_enters_valid_user_name_and_password() {
        page.userName.sendKeys(ConfigReader.getProperty("username"));
        page.password.sendKeys(ConfigReader.getProperty("password"));
        page.loginButton.click();
    }

    @When("I am on the Benefits Dashboard page")
    public void i_am_on_the_Benefits_Dashboard_page() {
        String actualText=homePage.validateTitle.getText();
        String expectedText="Benefits Dashboard";
        Assert.assertEquals(expectedText,actualText);

    }

    @When("I select Add Employee")
    public void i_select_Add_Employee() {

        homePage.addEmp.click();
    }

    @When("I should be able able to enter employee details")
    public void i_should_be_able_able_to_enter_employee_details() {
       homePage.firstName.sendKeys(ConfigReader.getProperty("firstname"));
       homePage.lastName.sendKeys(ConfigReader.getProperty("lastname"));
       homePage.dependent.sendKeys(ConfigReader.getProperty("dependent"));
    }

    @When("First Name does bot begin {string} or {string}")
    public void first_Name_does_bot_begin_or(String string, String string2) {
        String actualName=ConfigReader.getProperty("firstname");
        Assert.assertTrue(!actualName.startsWith("A")&&!actualName.startsWith("a"));
    }

    @When("the employee should save")
    public void the_employee_should_save() {
       homePage.submitButton.click();
    }

    @When("I should see the employee in the table")
    public void i_should_see_the_employee_in_the_table() {
       Assert.assertEquals("Muammer",homePage.name.getText());
       Assert.assertEquals("Turan",homePage.getlastName.getText());

    }

    @When("the benefit cost calculations are correct")
    public void the_benefit_cost_calculations_are_correct() {
       double expBenefitsCost=(double) 1000/(double)26;
       double actBenefitsCost=Double.parseDouble(homePage.benefits.getText());
       String result=expBenefitsCost+"";
       double res=Double.parseDouble(result.substring(0,result.indexOf(".")+3));
        System.out.println(res);
       Assert.assertTrue(res==actBenefitsCost);

    }



}

