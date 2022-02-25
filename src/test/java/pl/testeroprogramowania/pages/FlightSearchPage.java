package pl.testeroprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.testeroprogramowania.utils.SeleniumHelper;

public class FlightSearchPage {


    @FindBy(xpath = "//*[@id='s2id_location_from']//a")
    private WebElement originLocationField;

    @FindBy(xpath = "//*[@id='select2-drop']//div//input")
    private WebElement origin;

    @FindBy(xpath = "//*[@id='s2id_location_to']//a")
    private WebElement destinationLocationField;

    @FindBy(xpath = "//*[@id='select2-drop']//div//input")
    private WebElement destination;

    @FindBy(name = "departure")
    private WebElement departureDateInput;

    @FindBy(name = "arrival")
    private WebElement arrivalDateInput;

    @FindBy(name = "totalManualPassenger")
    private WebElement numberOfPassengers;

    @FindBy(xpath = "//select[@name='madult']")
    private WebElement setAdults;

    @FindBy(xpath = "//select[@name='mchildren']")
    private WebElement setChild;

    @FindBy(xpath = "//select[@name='minfant']")
    private WebElement setInfant;

    @FindBy(id = "sumManualPassenger")
    private WebElement guestsDoneButton;

    @FindBy(xpath = "//div[@class='bgfade col-md-3 col-xs-12 search-button']//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//select[@name='cabinclass']")
    private WebElement selectClass;


    private WebDriver driver;

    public FlightSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public FlightSearchPage setTripType(String tripType) {
        WebElement trip = driver.findElement(By.xpath("//label[contains(text(), '" + tripType + "')]"));
        trip.click();
        return this;

    }

    public FlightSearchPage setClass(String className) {
        Select classes = new Select(selectClass);
        classes.selectByValue(className);
        return this;
    }

    public FlightSearchPage setLocations(String depCity, String arrivCity) {
        originLocationField.click();
        origin.sendKeys(depCity);
        String depCityXpath = String.format("//span[@class='select2-match' and text()='%s']", depCity);
        SeleniumHelper.waitForElementToExist(driver, By.xpath(depCityXpath));
        driver.findElement(By.xpath(depCityXpath)).click();

        destinationLocationField.click();
        destination.sendKeys(arrivCity);
        String arrivCityXpath = String.format("//span[@class='select2-match' and text()='%s']", arrivCity);
        SeleniumHelper.waitForElementToExist(driver, By.xpath(arrivCityXpath));
        driver.findElement(By.xpath(arrivCityXpath)).click();

        return this;
    }

    public FlightSearchPage setDepartureDate(String departureDate) {
        departureDateInput.sendKeys(departureDate);
        return this;
    }

    public FlightSearchPage setReturnDate(String returnDate) {
        arrivalDateInput.sendKeys(returnDate);
        return this;
    }


    public FlightSearchPage setNumberOfPassengers(int adults, int child, int infant) {
        numberOfPassengers.click();
        Select adultCount = new Select(setAdults);
        adultCount.selectByValue(String.valueOf(adults));

        Select childCount = new Select(setChild);
        childCount.selectByValue(String.valueOf(child));

        Select infantCount = new Select(setInfant);
        infantCount.selectByValue(String.valueOf(infant));

        guestsDoneButton.click();
        return this;
    }

    public ResultPage performSearch() {
        searchButton.click();
        return new ResultPage(driver);
    }


}
