package pl.testeroprogramowania.tests;

import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.CarSearchPage;

public class CarSearchTest extends BaseTest {

    @Test
    public void searchForCarToRent() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton(driver);
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDepDate("12/02/2022");
        carSearchPage.setDepTime();
        carSearchPage.setReturnDate("16/02/2022");
        carSearchPage.setReturnTime();
        carSearchPage.performSearch();
    }


}