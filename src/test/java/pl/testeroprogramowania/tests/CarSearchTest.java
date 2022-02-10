package pl.testeroprogramowania.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.CarSearchPage;
import pl.testeroprogramowania.pages.ResultPage;
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

        ResultPage resultPage = new ResultPage(driver);
        System.out.println(resultPage.getLocationName());
        Assert.assertEquals(resultPage.getLocationName(), "Manchester");

    }
    /*
    @Test
    public void searchForCarToRentDifLocations() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton(driver);
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDropOffLocation("Dubai");
        carSearchPage.setDepDate("15/03/2022");
        carSearchPage.setDepTime();
        carSearchPage.setReturnDate("25/03/2022");
        carSearchPage.setReturnTime();
        carSearchPage.performSearch();

    }
    */
    @Test
    public void searchWithNonExistentDate() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton(driver);
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDepDate("32/02/2022");
        carSearchPage.setDepTime();
        carSearchPage.setReturnDate("55/14/2022");
        carSearchPage.setReturnTime();
        carSearchPage.performSearch();
    }

    @Test
    public void searchWithInvalidDateCharacters() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton(driver);
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDepDate("we/t5/woo2");
        carSearchPage.setDepTime();
        carSearchPage.setReturnDate("r5e32009");
        carSearchPage.setReturnTime();
        carSearchPage.performSearch();
    }

    @Test
    public void searchWithInvalidTimeCharacters() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton(driver);
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDepDate("22/02/2022");
        carSearchPage.setInvDepTime();
        carSearchPage.setReturnDate("15/11/2022");
        carSearchPage.setInvReturnTime();
        carSearchPage.performSearch();
    }

    @Test
    public void searchWithDateFromThePast() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton(driver);
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDepDate("18/02/922");
        carSearchPage.setDepTime();
        carSearchPage.setReturnDate("18/04/1918");
        carSearchPage.setReturnTime();
        carSearchPage.performSearch();
    }

    @Test
    public void searchWithoutCityName() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton(driver);
        carSearchPage.clearLocationField();
        carSearchPage.setDepDate("12/02/2022");
        carSearchPage.setDepTime();
        carSearchPage.setReturnDate("16/02/2022");
        carSearchPage.setReturnTime();
        carSearchPage.performSearch();

//Uwaga - należy jeszcze sprawdzić czy pojawia się komunikat "Wybierz element z listy"
    }
    @Test(dataProvider = "data")
    public void searchWithDataProvider(String city) {
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