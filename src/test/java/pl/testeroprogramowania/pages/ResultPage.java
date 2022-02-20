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

    @FindBy(xpath = "//h4[contains(@class, 'list_title')]//b")
    private List<WebElement> toursList;


    @FindBy(xpath = "//div[@class='itemscontainer']//h1")
    public WebElement resultHeading;


    public ResultPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public List<String> getCarModels() {
        return carList.stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());
    }
    public List<String> getToursPlace() {
        return toursList.stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

    public String getResultHeadingText(){
        return resultHeading.getText();
    }

}