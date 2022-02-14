package pl.testeroprogramowania.pages;

import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(xpath = "//span[contains(text(),'Drop off')]")
    private WebElement dropOffLocation;

    @FindBy(xpath = "//div[contains(text(),'Manchester')]")
    private WebElement getDropOffLocationCity;

    @FindBy(name = "dropoffLocation")
    private WebElement setDropOffLOcation;



    @FindBy(id = "departcar")
    private WebElement carDepart;

    @FindBy(name = "pickupTime")
    private WebElement pickUpTime;

    @FindBy(id = "returncar")
    private WebElement carReturn;

    @FindBy(name = "dropoffTime")
    private WebElement dropOffTime;

    @FindBy(xpath = "//*[@id='cars']/form/div[7]/button")
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
        setDropOffLOcation.click();
        getDropOffLocationCity.click();
        getDropOffLocationCity.clear();
        locationInput.sendKeys(dropOffCityName);
        getDropOffLocationCity.sendKeys(Keys.ENTER);
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
    public void setDepTime(){
        pickUpTime.sendKeys("04:00");

    }
    public void setInvDepTime(){
        pickUpTime.sendKeys("Early");

    }
    public void setReturnDate(String returnDate){
        carReturn.clear();
        carReturn.sendKeys(returnDate);
    }
    public void setReturnTime(){
        dropOffTime.sendKeys("13:30");

    }
    public void setInvReturnTime(){
        dropOffTime.sendKeys("Late");

    }
    public void performSearch(){
        pressCarSearchButton.click();
    }






}