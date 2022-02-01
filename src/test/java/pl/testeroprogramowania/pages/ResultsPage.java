package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

    @FindBy(xpath = "//b[contains(text(), 'Kia Pacanto 2014')]")
    public WebElement expectedCar;

    @FindBy(xpath = "//a[contains(text(), 'Manchester')]")
    public WebElement expectedLocation;


    public ResultsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public String getLocationName(){
        return expectedLocation.getText();

    }
    public String getCarName(){
        return expectedCar.getText();
    }

}
