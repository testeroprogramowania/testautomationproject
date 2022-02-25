package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPage {


    @FindBy(xpath = "//h4[contains(@class, 'list_title')]//b")
    private List<WebElement> carList;

    @FindBy(xpath = "//button[@id='bookbtn']")
    private List<WebElement> bookButtonList;

    @FindBy(xpath = "//div[@class='itemscontainer']//h1")
    public WebElement resultHeading;

    @FindBy(xpath = "//div[contains(text(), 'Dates Availability')]")
    public WebElement flightsResultHeading;


    private WebDriver driver;

    public ResultPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        
    }

    public List<String> getResultList() {
        return bookButtonList.stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

    public List<String> getCarModels() {
        return carList.stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

    public String getResultHeadingText(){
        return resultHeading.getText();
    }
    public String getFlightResultHeadingText(){
        return flightsResultHeading.getText();
    }

    public BookFlightPage bookAFlight(int numberOnTheList){
        bookButtonList.get(numberOnTheList).click();
        return new BookFlightPage(driver);

    }
}