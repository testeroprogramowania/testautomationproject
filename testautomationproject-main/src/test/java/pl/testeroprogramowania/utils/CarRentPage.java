package pl.testeroprogramowania.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarRentPage {

    @FindBy(xpath = "//span[@class='hidden-xs' and text()='Cars     ']")
    private WebElement tabCars;

    @FindBy(className = "select2-chosen")
    private WebElement pickUPLocation;

    @FindBy(xpath = "//div[@id='s2id_carlocations']//input")
    private WebElement pickUpLocationInput;

    @FindBy(xpath = "//div[@id='s2id_carlocations2']//input")
    private WebElement dropOffLocationInput;

    @FindBy(xpath = "//input[@class='form input-lg RTL' and @id='departcar']")
    private WebElement departCarDataInput;

    @FindBy(name = "pickupTime")
    private WebElement pickupTimeInput;

    @FindBy(xpath = "//input[@class='form input-lg RTL' and @id='returncar']")
    private WebElement dropoffDateInput;

    @FindBy(name = "dropoffTime")
    private WebElement dropoffTimeInput;

    @FindBy(xpath = "//div[@class='bgfade col-md-2 form-group go-right col-xs-12 search-button']")
    private WebElement searchButton;


    private WebDriver driver;

    public CarRentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CarRentPage pickUpLocation(String cityPickUp) {
        tabCars.click();
        pickUpLocationInput.sendKeys(cityPickUp);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", cityPickUp);
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    public CarRentPage dropOffLocation(String cityDropOff) {
        tabCars.click();
        dropOffLocationInput.sendKeys(cityDropOff);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", cityDropOff);
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    public CarRentPage setDates(String departData, String dropoffData) {
        departCarDataInput.clear();
        departCarDataInput.sendKeys("21/11/2022");
        dropoffDateInput.clear();
        dropoffDateInput.sendKeys("22/11/2022");
        return this;
    }

    public CarRentPage setTimeRent(String pickupTime, String dropoffTime) {
        pickupTimeInput.sendKeys("10:00");
        dropoffTimeInput.sendKeys("12:00");
        return this;
    }

    public void searchButton() {
        searchButton.click();
    }

    public CarResultsPage performSearch() {
        searchButton.click();
        return new CarResultsPage(driver);
    }
}
