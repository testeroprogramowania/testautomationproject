package pl.testeroprogramowania.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.CarSearchPage;
import pl.testeroprogramowania.utils.ExcelImport;

import java.io.IOException;

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

        /*
        ResultsPage resultsPage = new ResultsPage(driver);

        Assert.assertTrue(resultsPage.expectedCar.isDisplayed());
        Assert.assertTrue(resultsPage.expectedLocation.isDisplayed());

        Assert.assertEquals(resultsPage.getCarName(), "Kia Pacanto");
        Assert.assertEquals(resultsPage.getLocationName(), "Manchester");
        */
    }
    @Test(dataProvider = "data")
    public void searchForCarToRentWithDataProvider(String city) {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton(driver);
        carSearchPage.setLocation(city);
        carSearchPage.setDepDate("12/02/2022");
        carSearchPage.setDepTime();
        carSearchPage.setReturnDate("16/02/2022");
        carSearchPage.setReturnTime();
        carSearchPage.performSearch();


    }
    @DataProvider
    public Object[][] data() throws IOException {
        return ExcelImport.readExcel("citiesData.xls");
    }



}