package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    @FindBy(xpath = "//span[contains(text(), 'Flights')]")
    private WebElement searchFlightButton;

    @FindBy(xpath = "//li[@id='li_myaccount']")
    private List<WebElement> myAccountButtonLink;

    @FindBy(xpath = "//a[text()='  Sign Up']")
    private List<WebElement> signUpLink;


    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

public FlightSearchPage openFlightSearchPage(){
        searchFlightButton.click();
        return new FlightSearchPage(driver);
}
    public SignUpPage openSignUpForm() {
        myAccountButtonLink.stream().filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);
        signUpLink.get(1).click();
        return new SignUpPage(driver);
    }


}

