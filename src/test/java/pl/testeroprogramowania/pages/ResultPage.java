package pl.testeroprogramowania.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static javax.swing.UIManager.get;

public class ResultPage {


    @FindBy(xpath = "//h4[contains(@class, 'list_title')]//b")
    private List<WebElement> carList;

    @FindBy(xpath = "//button[@id='bookbtn']")
    private List<WebElement> bookButtonList;

    @FindBy(xpath = "//div[@class='itemscontainer']//h1")
    private WebElement resultHeading;

    @FindBy(xpath = "//div[@class='panel-heading'] [contains(text(), 'Available Flights')]")
    private WebElement flightsResultHeading;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement noResultsAlert;

    @FindBy(xpath = "//input[@id='nonstop']/..")
    private WebElement nonStopFil;

    @FindBy(xpath = "//input[@id='nonstop1']/..")
    private WebElement transitFil;

    @FindBy(xpath = "//input[@id='Refundable']/..")
    private WebElement refundableFil;

    @FindBy(xpath = "//input[@id='checkairLufthansa CityLine']/..")
    private WebElement lufthansaFil;






    private WebDriver driver;


    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public List<String> getCarModels() {
        return carList.stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

    public String getResultHeadingText() {
        return resultHeading.getText();
    }

    public String getFlightResultHeadingText() {
        return flightsResultHeading.getText();
    }

    public WebElement getNoResultsAlert() {
        return noResultsAlert;
    }

    public BookFlightPage bookAFlight(int numberOnTheList) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", bookButtonList.get(numberOnTheList));
        bookButtonList.get(numberOnTheList).click();
        return new BookFlightPage(driver);

    }

    public ResultPage nonStopFilter() {
        nonStopFil.click();
        return this;
    }
    public ResultPage transitFilter() {
        transitFil.click();
        return this;
    }
    public ResultPage refundableFilter() {
        refundableFil.click();
        return this;
    }
    public ResultPage lufthansaFilter() {
        lufthansaFil.click();
        return this;
    }


}
