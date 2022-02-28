package pl.testeroprogramowania.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {

    public static void waitForElementToExist(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10l);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
