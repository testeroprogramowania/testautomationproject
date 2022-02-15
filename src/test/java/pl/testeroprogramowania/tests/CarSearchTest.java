package pl.testeroprogramowania.tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.CarSearchPage;
import pl.testeroprogramowania.pages.ResultPage;
import pl.testeroprogramowania.utils.ExcelImport;

import java.io.IOException;
import java.util.List;

public class CarSearchTest extends BaseTest {

    @Test
    public void searchForCarToRent() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton();
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDepDate("12/02/2022");
        carSearchPage.setDepTime("12:30");
        carSearchPage.setReturnDate("16/02/2022");
        carSearchPage.setReturnTime("17:00");
        carSearchPage.performSearch();

        ResultPage resultPage = new ResultPage(driver);
        List<String> carNames = resultPage.getCarModels();
        System.out.println(resultPage.getCarModels());
        Assert.assertEquals(carNames.get(0),"Kia Pacanto 2014                  ");

    }

    @Test
    public void searchForCarToRentDifLocations() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton();
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDropOffLocation("Alexandria");
        carSearchPage.setDepDate("15/03/2022");
        carSearchPage.setDepTime("12:45");
        carSearchPage.setReturnDate("25/03/2022");
        carSearchPage.setReturnTime("17:45");
        carSearchPage.performSearch();

        ResultPage resultPage = new ResultPage(driver);
        Assert.assertEquals(resultPage.getResultHeadingText(),"No Results Found");

    }

    @Test
    public void searchWithNonExistentDate() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton();
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDepDate("32/02/2022");
        carSearchPage.setDepTime("12:45");
        carSearchPage.setReturnDate("55/14/2022");
        carSearchPage.setReturnTime("17:45");
        carSearchPage.performSearch();
    }

    @Test
    public void searchWithInvalidDateCharacters() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton();
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDepDate("we/t5/woo2");
        carSearchPage.setDepTime("12:45");
        carSearchPage.setReturnDate("r5e32009");
        carSearchPage.setReturnTime("17:45");
        carSearchPage.performSearch();
    }

    @Test
    public void searchWithInvalidTimeCharacters() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton();
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDepDate("22/02/2022");
        carSearchPage.setReturnDate("15/11/2022");
        carSearchPage.setInvTime("OO:E3","UU,2d");
        carSearchPage.performSearch();
    }

    @Test
    public void searchWithDateFromThePast() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton();
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDepDate("18/02/922");
        carSearchPage.setDepTime("12:45");
        carSearchPage.setReturnDate("18/04/1918");
        carSearchPage.setReturnTime("17:45");
        carSearchPage.performSearch();
    }

    @Test
    public void searchWithoutCityName() {

        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton();
        carSearchPage.clearLocationField();
        carSearchPage.setDepDate("12/02/2022");
        carSearchPage.setDepTime("12:45");
        carSearchPage.setReturnDate("16/02/2022");
        carSearchPage.setReturnTime("17:45");
        carSearchPage.performSearch();

    }
    @Test(dataProvider = "data")
    public void searchWithDataProvider(String city) {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton();
        carSearchPage.setLocation(city);
        carSearchPage.setDepDate("12/02/2022");
        carSearchPage.setDepTime("12:45");
        carSearchPage.setReturnDate("16/02/2022");
        carSearchPage.setReturnTime("17:45");
        carSearchPage.performSearch();


    }
    @DataProvider
    public Object[][] data() throws IOException {
        return ExcelImport.readExcel("citiesData.xls");
    }



}