package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class BookFlightPage {

    @FindBy(id = "guesttab")
    private WebElement guestButton;

    @FindBy(id = "signintab")
    private WebElement sigInButton;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInput;

    @FindBy(name ="lastname")
    private WebElement lastNameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "confirmemail")
    private WebElement confirmEmailInput;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(name = "address")
    private WebElement addressInput;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement countryName;

    @FindBy(xpath = "//button[@name='guest']")
    private WebElement confirmButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private List<WebElement> registerFormErrors;

    private WebDriver driver;


    public BookFlightPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

public BookFlightPage fillTheForm(){
        guestButton.click();
        firstNameInput.click();
        firstNameInput.sendKeys("Quality");
        lastNameInput.click();
        lastNameInput.sendKeys("Assurance");
        emailInput.sendKeys("test@mordor.waw.pl");
        confirmEmailInput.sendKeys("test@mordor.waw.pl");
        phoneInput.sendKeys("+497761128872");
        addressInput.sendKeys("95022 München, Geyerswörtherstraße 55");
        String country = "Germany";
        Select setCountry = new Select(countryName);
        setCountry.selectByVisibleText(country);

        return this;
        }

    public List<String> getErrors() {
        return registerFormErrors.stream().map(WebElement::getText).collect(Collectors.toList());

    }



        public PaymentPage proceedToPayment(){
        confirmButton.click();
        return new PaymentPage(driver);
        }
}
