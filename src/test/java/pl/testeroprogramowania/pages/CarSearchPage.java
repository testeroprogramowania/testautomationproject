package pl.testeroprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarSearchPage {
    @FindBy(xpath = "//span[contains(text(), 'Cars')]")
    private WebElement carSearchButton;

    @FindBy(xpath = "//span[contains(text(), 'Pick up')]")
    private WebElement searchCarSpan;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement locationInput;

    @FindBy(xpath = "//div[@id='s2id_carlocations2']//input")
    private WebElement dropOffLocationInput;

    @FindBy(id = "departcar")
    private WebElement carDepart;

    @FindBy(name = "pickupTime")
    private WebElement pickUpTime;

    @FindBy(id = "returncar")
    private WebElement carReturn;

    @FindBy(name = "dropoffTime")
    private WebElement dropOffTime;

    @FindBy(xpath = "//div[@id='cars']//button[@type='submit']")
    private WebElement pressCarSearchButton;

    public CarSearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    private WebDriver driver;

    public void clickCarsButton(){
        carSearchButton.click();
    }
    public void setLocation(String cityName) {
        searchCarSpan.click();
        locationInput.sendKeys(cityName);
        locationInput.sendKeys(Keys.ENTER);
    }
    public void setDropOffLocation(String dropOffCityName){
        carSearchButton.click();
        dropOffLocationInput.sendKeys(dropOffCityName);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", dropOffCityName);
        driver.findElement(By.xpath(xpath)).click();
    }
    public void clearLocationField(){
        searchCarSpan.click();
        locationInput.clear();
        locationInput.sendKeys(Keys.ENTER);
    }
    public void setDepDate(String depDate){
        carDepart.clear();
        carDepart.sendKeys(depDate);
    }
    public void setDepTime(String depTime){
        pickUpTime.sendKeys(depTime);
    }
    public void setReturnDate(String returnDate){
        carReturn.clear();
        carReturn.sendKeys(returnDate);
    }
    public void setReturnTime(String returnTime){
        dropOffTime.sendKeys(returnTime);
    }
    public void setInvTime(String invDepTime, String invReturnTime){
        pickUpTime.sendKeys(invDepTime);
        dropOffTime.sendKeys(invReturnTime);
    }
    public ResultPage performSearch(){
        pressCarSearchButton.click();
        return new ResultPage(driver);
    }






}