package pl.testeroprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToursSearchPage {

    @FindBy (xpath = "//span[contains(text(), 'Tours')]")
    private WebElement toursSearchButton;

    @FindBy (xpath = "//span[contains(text(), 'Search by Listing or City Name')]")
    private WebElement searchByListingOrCityName;

    @FindBy (xpath = "//div[@id='select2-drop']//input")
    private WebElement locationToursInput;

    @FindBy (xpath = "//div[@id='select2-drop']//li")
    private WebElement noMatchesfound;

    @FindBy (xpath = "//span[@class='select2-match']")
    private WebElement locationFind;

    @FindBy (xpath = "//div[@id='tchkin']//input")
    private WebElement toursPlaceHolderDate;

    @FindBy (id = "adults")
    private WebElement choiceOfTheNumberOfGuests;

    @FindBy (xpath = "//div[@id='s2id_tourtype']//input")
    private WebElement tourType;

    @FindBy (xpath = "//div[@id='tours']//button[@type='submit']")
    private WebElement pressToursSearchButton;

    private WebDriver driver;

    public ToursSearchPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickToursButton(){
        toursSearchButton.click();
    }

    public void setLocation(String location){
        searchByListingOrCityName.click();
        locationToursInput.sendKeys(location);
        locationFind.click();
    }

    public void setNoExistCityName(String location){
        searchByListingOrCityName.click();
        locationToursInput.sendKeys(location);
        noMatchesfound.isDisplayed();
    }

    public void setNoExistToursType (String typeTours){
        toursSearchButton.click();
        tourType.sendKeys(typeTours);
        noMatchesfound.isDisplayed();
    }

    public void setCheckInDate (String checkInDate){
        toursPlaceHolderDate.clear();
        toursPlaceHolderDate.sendKeys(checkInDate);
    }

    public void clearDate(){
        toursPlaceHolderDate.clear();
    }

    public void setNumbersOfGuests(String numbersOfGuests)
    {
        choiceOfTheNumberOfGuests.sendKeys(numbersOfGuests);
    }

    public void setTypeTour(String typeTours){
        toursSearchButton.click();
        tourType.sendKeys(typeTours);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']",typeTours);
        driver.findElement(By.xpath(xpath)).click();
    }

    public ResultPage performSearch(){
        pressToursSearchButton.click();
        return new ResultPage(driver);
    }
}
