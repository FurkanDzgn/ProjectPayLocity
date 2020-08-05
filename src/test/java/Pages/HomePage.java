package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//div[@class='page-header jumbotron']//h1")
    public WebElement validateTitle;

    @FindBy(id="btnAddEmployee")
    public WebElement addEmp;

    @FindBy(xpath = "//label[@for='firstname']//following-sibling::div//input")
    public WebElement firstName;

    @FindBy(xpath = "//label[@for='lastname']//following-sibling::div//input")
    public WebElement lastName;

    @FindBy(xpath = "//label[@for='dependents']//following-sibling::div//input")
    public WebElement dependent;

    @FindBy(xpath = "//div[@class='col-sm-offset-2 col-sm-10']/button[1]")
    public WebElement submitButton;

    @FindBy(xpath = "//tr//td[.='Muammer']")
    public WebElement name;

    @FindBy(xpath = "//tr//td[.='Turan']")
    public WebElement getlastName;

    @FindBy(xpath = "//tr//td[.='38.46']")
    public WebElement benefits;

    @FindBy(xpath = "//td[.='Archel']")
    public WebElement nameCase2;

    @FindBy(xpath = "//td[.='lee']")
    public WebElement lastNameCase2;

    @FindBy(xpath = "//tr//td[.='34.62']")
    public WebElement benefitsCase2;

    @FindBy(id="btnEdit")
    public WebElement editButton;

    @FindBy(xpath = "//td[.='Frank']")
    public WebElement nameCase3;

    @FindBy(xpath = "//td[.='Chap']")
    public WebElement lastNameCase3;

    @FindBy(id="btnDelete")
    public WebElement deleteButton;
}

