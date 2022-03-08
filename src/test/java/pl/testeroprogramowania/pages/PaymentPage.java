package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    @FindBy(xpath = "//div[contains(text(), 'Invoice')]")
    private WebElement invoiceDiv;

    @FindBy(xpath = "//button[contains(text(),'Pay on Arrival')]")
    private WebElement payOnArrivalButton;


    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
