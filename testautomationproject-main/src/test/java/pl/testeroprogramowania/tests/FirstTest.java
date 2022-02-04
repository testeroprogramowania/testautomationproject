package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.utils.DriverFactory;

public class FirstTest {

    @Test
    public void openPageFirefox() {
       WebDriver driver = DriverFactory.getDriver("firefox");
       driver.get("https://www.testeroprogramowania.pl");
       Assert.assertTrue(driver.getTitle().contains("Testowanie"));
       driver.quit();
    }

    @Test
    public void openPageChrome() {
        WebDriver driver = DriverFactory.getDriver("chrome");
        driver.get("https://www.testeroprogramowania.pl");
        Assert.assertTrue(driver.getTitle().contains("Testowanie"));
        driver.quit();
    }
}
