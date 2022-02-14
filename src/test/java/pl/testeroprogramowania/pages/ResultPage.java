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
    //Warto pobierać lokalizację czymś bardziej uniwersalnym np. //h4[contains(@Class,'list_title')]/following-sibling::a


    public ResultPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public List<String> getCarModels() {
        return carList.stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());
    }
}