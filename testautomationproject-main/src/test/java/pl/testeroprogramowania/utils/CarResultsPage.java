package pl.testeroprogramowania.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CarResultsPage {

    @FindBy(xpath = "//h4[contains(@class, 'list_title')]//b")
    private List<WebElement> carlList;

    @FindBy(xpath = "//div[@class='itemscontainer']//h2")
    public WebElement resultHeading;

    public CarResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public List<String> getCarNames() {
        return carlList.stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

    public String getHeadingText() {
        return resultHeading.getText();
    }
}
