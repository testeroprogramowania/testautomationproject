package pl.testeroprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.testeroprogramowania.utils.SeleniumHelper;

import java.util.List;

public class HotelSearchPage {
    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchHotelSpan;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchHotelInput;

    @FindBy(name = "checkin")
    private WebElement checkinInput;

    @FindBy(name = "checkout")
    private WebElement checkoutInput;

    @FindBy(id ="travellersInput" )
    private WebElement travelersInput;

    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy(id ="childPlusBtn" )
    private WebElement childPlusBtn;

    @FindBy(xpath ="//button[text()=' Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//li[@id='li_myaccount']")
    private List<WebElement> myAccountLink;

    @FindBy(xpath = "//a[text()='  Sign Up']")
    private List<WebElement> signUpLink;

    private WebDriver driver;

    public HotelSearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public void setCityName(String cityName){
        searchHotelSpan.click();
        searchHotelInput.sendKeys(cityName);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", cityName);
        SeleniumHelper.waitForElementToExist(driver, By.xpath(xpath));
        driver.findElement(By.xpath(xpath)).click();

    }
    public void setCheckInOutDates(String checkin, String checkout){

        checkinInput.sendKeys(checkin);
        checkoutInput.sendKeys(checkout);
    }
    public void setNumberOfGuests(int addAdult, int addChild){
        travelersInput.click();
        addPerson(adultPlusBtn, addAdult);
        addPerson(childPlusBtn, addChild);

    }
    private void addPerson(WebElement travelerBtn, int numberOfGuests){
        for (int i=0; i<=numberOfGuests; i++){
            travelerBtn.click();
        }
    }
    public void performSearch(){
        searchButton.click();
    }

}
