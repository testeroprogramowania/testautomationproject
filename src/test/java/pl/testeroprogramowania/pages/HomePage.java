package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//span[contains(text(), 'Flights')]")
    private WebElement searchFlightButton;


    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

public FlightSearchPage openFlightSearchPage(){
        searchFlightButton.click();
        return new FlightSearchPage(driver);
}


}

