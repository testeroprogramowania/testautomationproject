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


    private WebDriver driver;

    public void clickCarsButton(WebDriver driver){
        carSearchButton.click();
    }

    public void setLocation(String cityName) {
        searchCarSpan.click();
        locationInput.sendKeys(cityName);
        locationInput.sendKeys(Keys.ENTER);
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
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].value='03:30';", pickUpTime);
    }
    public void setReturnDate(String returnDate){
        carReturn.clear();
        carReturn.sendKeys(returnDate);
    }
    public void setReturnTime(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value='08:30';", dropOffTime);
    }
    public void performSearch(){
        pressCarSearchButton.click();
    }

    public CarSearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }


}