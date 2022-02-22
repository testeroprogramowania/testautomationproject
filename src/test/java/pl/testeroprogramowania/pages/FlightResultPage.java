package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FlightResultPage {

    private WebDriver driver;

    public FlightResultPage(WebDriver driver){

        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

}
