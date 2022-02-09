package pl.testeroprogramowania.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {


    @FindBy(xpath = "//a[@title='Manchester']")
    public WebElement expectedLocation;

    public ResultPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    public String getLocationName(){
        return expectedLocation.getAttribute("title");

    }


}