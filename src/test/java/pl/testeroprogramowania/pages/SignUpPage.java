package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pl.testeroprogramowania.models.Customer;

import java.util.List;

public class SignUpPage {
    @FindBy(name = "firstname")
    private WebElement firstNameInput;

    @FindBy(name = "lastname")
    private WebElement lastNameInput;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "confirmpassword")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[text()=' Sign Up']")
    private WebElement signUpButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement signUpErrors;

    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage fillTheForm(Customer customer) {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        phoneInput.sendKeys(customer.getPhone());
        emailInput.sendKeys(customer.getEmail());
        passwordInput.sendKeys(customer.getPassword());
        confirmPasswordInput.sendKeys(customer.getPassword());
        signUpButton.click();

        return new LoggedUserPage(driver);

    }

    public SignUpPage fillTheFormWithExistentEmail(Customer customer) {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        phoneInput.sendKeys(customer.getPhone());
        emailInput.sendKeys(customer.getEmail());
        passwordInput.sendKeys(customer.getPassword());
        confirmPasswordInput.sendKeys(customer.getPassword());
        signUpButton.click();

        return this;

    }


    public WebElement getSignUpErrors() {
        return signUpErrors;
    }
}
